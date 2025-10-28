package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.Test;

class PDLayoutAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDLayoutAttributeObject#getPlacement()}
   */
  @Test
  void testGetPlacement() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.PLACEMENT_INLINE, (new PDLayoutAttributeObject()).getPlacement());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setPlacement(String)}
   */
  @Test
  void testSetPlacement() {
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
   * Method under test: {@link PDLayoutAttributeObject#setPlacement(String)}
   */
  @Test
  void testSetPlacement2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setPlacement(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, pdLayoutAttributeObject.getPlacement());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getWritingMode()}
   */
  @Test
  void testGetWritingMode() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.WRITING_MODE_LRTB, (new PDLayoutAttributeObject()).getWritingMode());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setWritingMode(String)}
   */
  @Test
  void testSetWritingMode() {
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
   * Method under test: {@link PDLayoutAttributeObject#getBackgroundColor()}
   */
  @Test
  void testGetBackgroundColor() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getBackgroundColor());
    assertNull((new PDExportFormatAttributeObject("42HeadersSummary")).getBackgroundColor());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}
   */
  @Test
  void testSetBackgroundColor() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}
   */
  @Test
  void testSetBackgroundColor2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBackgroundColor(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getBackgroundColor());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}
   */
  @Test
  void testSetBackgroundColor3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setBackgroundColor(new PDGamma(array));

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    PDGamma backgroundColor = pdLayoutAttributeObject.getBackgroundColor();
    assertSame(array, backgroundColor.getCOSArray());
    assertSame(array, backgroundColor.getCOSObject());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getBorderColors()}
   */
  @Test
  void testGetBorderColors() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getBorderColors());
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getBorderColors());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}
   */
  @Test
  void testSetAllBorderColors() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}
   */
  @Test
  void testSetAllBorderColors2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderColors(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getBorderColors());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}
   */
  @Test
  void testSetAllBorderColors3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setAllBorderColors(new PDGamma(array));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdLayoutAttributeObject.getBorderColors());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}
   */
  @Test
  void testSetBorderColors() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}
   */
  @Test
  void testSetBorderColors2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBorderColors(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getBorderColors());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}
   */
  @Test
  void testSetBorderColors3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setBorderColors(new PDFourColours(array));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdLayoutAttributeObject.getBorderColors());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getBorderStyle()}
   */
  @Test
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, (new PDLayoutAttributeObject()).getBorderStyle());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setAllBorderStyles(String)}
   */
  @Test
  void testSetAllBorderStyles() {
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
   * Method under test: {@link PDLayoutAttributeObject#getBorderThickness()}
   */
  @Test
  void testGetBorderThickness() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getBorderThickness());
    assertNull((new PDExportFormatAttributeObject("42ColSpanColSpan")).getBorderThickness());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderThicknesses(float)}
   */
  @Test
  void testSetAllBorderThicknesses() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderThicknesses(float)}
   */
  @Test
  void testSetAllBorderThicknesses2() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("42OwnerRowSpan");

    // Act
    pdExportFormatAttributeObject.setAllBorderThicknesses(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdExportFormatAttributeObject.getBorderThickness()).floatValue());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)}
   */
  @Test
  void testSetAllBorderThicknesses3() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)}
   */
  @Test
  void testSetAllBorderThicknesses4() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderThicknesses(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getBorderThickness()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getPadding()}
   */
  @Test
  void testGetPadding() {
    // Arrange, Act and Assert
    assertEquals(0.0f, ((Float) (new PDLayoutAttributeObject()).getPadding()).floatValue());
    assertEquals(0.0f,
        ((Float) (new PDExportFormatAttributeObject("ColSpanListNumberingHeaders")).getPadding()).floatValue());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setAllPaddings(float)}
   */
  @Test
  void testSetAllPaddings() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllPaddings(int)}
   */
  @Test
  void testSetAllPaddings2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllPaddings(int)}
   */
  @Test
  void testSetAllPaddings3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getColor()}
   */
  @Test
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setColor(PDGamma)}
   */
  @Test
  void testSetColor() {
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
   * Method under test: {@link PDLayoutAttributeObject#setColor(PDGamma)}
   */
  @Test
  void testSetColor2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getColor());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setColor(PDGamma)}
   */
  @Test
  void testSetColor3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setColor(new PDGamma(array));

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    PDGamma color = pdLayoutAttributeObject.getColor();
    assertSame(array, color.getCOSArray());
    assertSame(array, color.getCOSObject());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getSpaceBefore()}
   */
  @Test
  void testGetSpaceBefore() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getSpaceBefore());
    assertEquals(0.0f, (new PDExportFormatAttributeObject(new COSStream())).getSpaceBefore());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(float)}
   */
  @Test
  void testSetSpaceBefore() {
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
   * Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(float)}
   */
  @Test
  void testSetSpaceBefore2() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject(
        "HeadersHeadersHeaders");

    // Act
    pdExportFormatAttributeObject.setSpaceBefore(10.0f);

    // Assert
    assertEquals(10.0f, pdExportFormatAttributeObject.getSpaceBefore());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(int)}
   */
  @Test
  void testSetSpaceBefore3() {
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
   * Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(int)}
   */
  @Test
  void testSetSpaceBefore4() {
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
   * Method under test: {@link PDLayoutAttributeObject#getSpaceAfter()}
   */
  @Test
  void testGetSpaceAfter() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getSpaceAfter());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(float)}
   */
  @Test
  void testSetSpaceAfter() {
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
   * Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(int)}
   */
  @Test
  void testSetSpaceAfter2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(int)}
   */
  @Test
  void testSetSpaceAfter3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getStartIndent()}
   */
  @Test
  void testGetStartIndent() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getStartIndent());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setStartIndent(float)}
   */
  @Test
  void testSetStartIndent() {
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
   * Method under test: {@link PDLayoutAttributeObject#setStartIndent(int)}
   */
  @Test
  void testSetStartIndent2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setStartIndent(int)}
   */
  @Test
  void testSetStartIndent3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getEndIndent()}
   */
  @Test
  void testGetEndIndent() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getEndIndent());
    assertEquals(0.0f, (new PDExportFormatAttributeObject("42SummaryOwner")).getEndIndent());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setEndIndent(float)}
   */
  @Test
  void testSetEndIndent() {
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
   * Method under test: {@link PDLayoutAttributeObject#setEndIndent(int)}
   */
  @Test
  void testSetEndIndent2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setEndIndent(int)}
   */
  @Test
  void testSetEndIndent3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTextIndent()}
   */
  @Test
  void testGetTextIndent() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getTextIndent());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setTextIndent(float)}
   */
  @Test
  void testSetTextIndent() {
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
   * Method under test: {@link PDLayoutAttributeObject#setTextIndent(int)}
   */
  @Test
  void testSetTextIndent2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setTextIndent(int)}
   */
  @Test
  void testSetTextIndent3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTextAlign()}
   */
  @Test
  void testGetTextAlign() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, (new PDLayoutAttributeObject()).getTextAlign());
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START,
        (new PDExportFormatAttributeObject("ColSpan42Summary")).getTextAlign());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setTextAlign(String)}
   */
  @Test
  void testSetTextAlign() {
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
   * Method under test: {@link PDLayoutAttributeObject#getBBox()}
   */
  @Test
  void testGetBBox() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getBBox());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox() {
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
   * Method under test: {@link PDLayoutAttributeObject#setBBox(PDRectangle)}
   */
  @Test
  void testSetBBox2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBBox(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getBBox());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, (new PDLayoutAttributeObject()).getWidth());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setWidthAuto()}
   */
  @Test
  void testSetWidthAuto() {
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
   * Method under test: {@link PDLayoutAttributeObject#setWidth(float)}
   */
  @Test
  void testSetWidth() {
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
   * Method under test: {@link PDLayoutAttributeObject#setWidth(int)}
   */
  @Test
  void testSetWidth2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setWidth(int)}
   */
  @Test
  void testSetWidth3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getHeight()}
   */
  @Test
  void testGetHeight() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, (new PDLayoutAttributeObject()).getHeight());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setHeightAuto()}
   */
  @Test
  void testSetHeightAuto() {
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
   * Method under test: {@link PDLayoutAttributeObject#setHeight(float)}
   */
  @Test
  void testSetHeight() {
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
   * Method under test: {@link PDLayoutAttributeObject#setHeight(int)}
   */
  @Test
  void testSetHeight2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setHeight(int)}
   */
  @Test
  void testSetHeight3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getBlockAlign()}
   */
  @Test
  void testGetBlockAlign() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, (new PDLayoutAttributeObject()).getBlockAlign());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setBlockAlign(String)}
   */
  @Test
  void testSetBlockAlign() {
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
   * Method under test: {@link PDLayoutAttributeObject#getInlineAlign()}
   */
  @Test
  void testGetInlineAlign() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, (new PDLayoutAttributeObject()).getInlineAlign());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setInlineAlign(String)}
   */
  @Test
  void testSetInlineAlign() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTBorderStyle()}
   */
  @Test
  void testGetTBorderStyle() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, (new PDLayoutAttributeObject()).getTBorderStyle());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE,
        (new PDExportFormatAttributeObject("SummaryHeaders")).getTBorderStyle());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setAllTBorderStyles(String)}
   */
  @Test
  void testSetAllTBorderStyles() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTPadding()}
   */
  @Test
  void testGetTPadding() {
    // Arrange, Act and Assert
    assertEquals(0.0f, ((Float) (new PDLayoutAttributeObject()).getTPadding()).floatValue());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(float)}
   */
  @Test
  void testSetAllTPaddings() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(int)}
   */
  @Test
  void testSetAllTPaddings2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(int)}
   */
  @Test
  void testSetAllTPaddings3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getBaselineShift()}
   */
  @Test
  void testGetBaselineShift() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDLayoutAttributeObject()).getBaselineShift());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setBaselineShift(float)}
   */
  @Test
  void testSetBaselineShift() {
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
   * Method under test: {@link PDLayoutAttributeObject#setBaselineShift(int)}
   */
  @Test
  void testSetBaselineShift2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setBaselineShift(int)}
   */
  @Test
  void testSetBaselineShift3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getLineHeight()}
   */
  @Test
  void testGetLineHeight() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.LINE_HEIGHT_NORMAL, (new PDLayoutAttributeObject()).getLineHeight());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setLineHeightNormal()}
   */
  @Test
  void testSetLineHeightNormal() {
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
   * Method under test: {@link PDLayoutAttributeObject#setLineHeightAuto()}
   */
  @Test
  void testSetLineHeightAuto() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeightAuto();

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, pdLayoutAttributeObject.getLineHeight());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setLineHeight(float)}
   */
  @Test
  void testSetLineHeight() {
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
   * Method under test: {@link PDLayoutAttributeObject#setLineHeight(int)}
   */
  @Test
  void testSetLineHeight2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setLineHeight(int)}
   */
  @Test
  void testSetLineHeight3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTextDecorationColor()}
   */
  @Test
  void testGetTextDecorationColor() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getTextDecorationColor());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}
   */
  @Test
  void testSetTextDecorationColor() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}
   */
  @Test
  void testSetTextDecorationColor2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationColor(null);

    // Assert
    assertNull(pdLayoutAttributeObject.getTextDecorationColor());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}
   */
  @Test
  void testSetTextDecorationColor3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setTextDecorationColor(new PDGamma(array));

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    PDGamma textDecorationColor = pdLayoutAttributeObject.getTextDecorationColor();
    assertSame(array, textDecorationColor.getCOSArray());
    assertSame(array, textDecorationColor.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#getTextDecorationThickness()}
   */
  @Test
  void testGetTextDecorationThickness() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getTextDecorationThickness());
    assertEquals(-1.0f, (new PDExportFormatAttributeObject("HeadersOwnerScope")).getTextDecorationThickness());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationThickness(float)}
   */
  @Test
  void testSetTextDecorationThickness() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationThickness(int)}
   */
  @Test
  void testSetTextDecorationThickness2() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationThickness(int)}
   */
  @Test
  void testSetTextDecorationThickness3() {
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
   * Method under test: {@link PDLayoutAttributeObject#getTextDecorationType()}
   */
  @Test
  void testGetTextDecorationType() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, (new PDLayoutAttributeObject()).getTextDecorationType());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setTextDecorationType(String)}
   */
  @Test
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
   * Method under test: {@link PDLayoutAttributeObject#getRubyAlign()}
   */
  @Test
  void testGetRubyAlign() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE, (new PDLayoutAttributeObject()).getRubyAlign());
    assertEquals(PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE,
        (new PDExportFormatAttributeObject("Headers42Owner")).getRubyAlign());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setRubyAlign(String)}
   */
  @Test
  void testSetRubyAlign() {
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
   * Method under test: {@link PDLayoutAttributeObject#getRubyPosition()}
   */
  @Test
  void testGetRubyPosition() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, (new PDLayoutAttributeObject()).getRubyPosition());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setRubyPosition(String)}
   */
  @Test
  void testSetRubyPosition() {
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
   * Method under test:
   * {@link PDLayoutAttributeObject#getGlyphOrientationVertical()}
   */
  @Test
  void testGetGlyphOrientationVertical() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        (new PDLayoutAttributeObject()).getGlyphOrientationVertical());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#setGlyphOrientationVertical(String)}
   */
  @Test
  void testSetGlyphOrientationVertical() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setGlyphOrientationVertical("Glyph Orientation Vertical");

    // Assert
    assertEquals("Glyph Orientation Vertical", pdLayoutAttributeObject.getGlyphOrientationVertical());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#getColumnCount()}
   */
  @Test
  void testGetColumnCount() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDLayoutAttributeObject()).getColumnCount());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setColumnCount(int)}
   */
  @Test
  void testSetColumnCount() {
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
   * Method under test: {@link PDLayoutAttributeObject#setColumnCount(int)}
   */
  @Test
  void testSetColumnCount2() {
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
   * Method under test: {@link PDLayoutAttributeObject#getColumnGap()}
   */
  @Test
  void testGetColumnGap() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColumnGap());
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getColumnGap());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setColumnGap(float)}
   */
  @Test
  void testSetColumnGap() {
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
   * Method under test: {@link PDLayoutAttributeObject#setColumnGap(float)}
   */
  @Test
  void testSetColumnGap2() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("42OwnerRowSpan");

    // Act
    pdExportFormatAttributeObject.setColumnGap(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdExportFormatAttributeObject.getColumnGap()).floatValue());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setColumnGap(int)}
   */
  @Test
  void testSetColumnGap3() {
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
   * Method under test: {@link PDLayoutAttributeObject#setColumnGap(int)}
   */
  @Test
  void testSetColumnGap4() {
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
   * Method under test: {@link PDLayoutAttributeObject#getColumnWidths()}
   */
  @Test
  void testGetColumnWidths() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColumnWidths());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(float)}
   */
  @Test
  void testSetAllColumnWidths() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(int)}
   */
  @Test
  void testSetAllColumnWidths2() {
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
   * Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(int)}
   */
  @Test
  void testSetAllColumnWidths3() {
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
   * Method under test: {@link PDLayoutAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=Layout", (new PDLayoutAttributeObject()).toString());
    assertEquals("O=null", (new PDLayoutAttributeObject(new COSDictionary())).toString());
    assertEquals("O=Owner", (new PDExportFormatAttributeObject("Owner")).toString());
  }

  /**
   * Method under test:
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDLayoutAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDLayoutAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}
   */
  @Test
  void testNewPDLayoutAttributeObject2() {
    // Arrange and Act
    PDLayoutAttributeObject actualPdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Assert
    assertNull(actualPdLayoutAttributeObject.getBorderColors());
    assertNull(actualPdLayoutAttributeObject.getBorderThickness());
    assertNull(actualPdLayoutAttributeObject.getColumnGap());
    assertNull(actualPdLayoutAttributeObject.getColumnWidths());
    COSDictionary cOSObject = actualPdLayoutAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
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
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, actualPdLayoutAttributeObject.getColumnCount());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdLayoutAttributeObject.isEmpty());
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, actualPdLayoutAttributeObject.getBlockAlign());
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, actualPdLayoutAttributeObject.getRubyPosition());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdLayoutAttributeObject.getTextDecorationType());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdLayoutAttributeObject.getBorderStyle());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdLayoutAttributeObject.getTBorderStyle());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdLayoutAttributeObject.getGlyphOrientationVertical());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, actualPdLayoutAttributeObject.getHeight());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO, actualPdLayoutAttributeObject.getWidth());
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdLayoutAttributeObject.getInlineAlign());
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdLayoutAttributeObject.getTextAlign());
    assertEquals(PDLayoutAttributeObject.LINE_HEIGHT_NORMAL, actualPdLayoutAttributeObject.getLineHeight());
    assertEquals(PDLayoutAttributeObject.OWNER_LAYOUT, actualPdLayoutAttributeObject.getOwner());
    assertEquals(PDLayoutAttributeObject.PLACEMENT_INLINE, actualPdLayoutAttributeObject.getPlacement());
    assertEquals(PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE, actualPdLayoutAttributeObject.getRubyAlign());
    assertEquals(PDLayoutAttributeObject.WRITING_MODE_LRTB, actualPdLayoutAttributeObject.getWritingMode());
  }
}
