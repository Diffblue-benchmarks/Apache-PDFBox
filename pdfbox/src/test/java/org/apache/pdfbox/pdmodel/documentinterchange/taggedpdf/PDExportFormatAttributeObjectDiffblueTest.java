package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDExportFormatAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDExportFormatAttributeObject#getListNumbering()}
   */
  @Test
  void testGetListNumbering() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE,
        (new PDExportFormatAttributeObject("Owner")).getListNumbering());
  }

  /**
   * Method under test:
   * {@link PDExportFormatAttributeObject#setListNumbering(String)}
   */
  @Test
  void testSetListNumbering() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setListNumbering("42");

    // Assert
    assertEquals("42", pdExportFormatAttributeObject.getListNumbering());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#getRowSpan()}
   */
  @Test
  void testGetRowSpan() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDExportFormatAttributeObject("Owner")).getRowSpan());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#setRowSpan(int)}
   */
  @Test
  void testSetRowSpan() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setRowSpan(1);

    // Assert
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#getColSpan()}
   */
  @Test
  void testGetColSpan() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDExportFormatAttributeObject("Owner")).getColSpan());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#setColSpan(int)}
   */
  @Test
  void testSetColSpan() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setColSpan(1);

    // Assert
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#getHeaders()}
   */
  @Test
  void testGetHeaders() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getHeaders());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#setHeaders(String[])}
   */
  @Test
  void testSetHeaders() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setHeaders(new String[]{"Headers"});

    // Assert
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#getScope()}
   */
  @Test
  void testGetScope() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getScope());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#setScope(String)}
   */
  @Test
  void testSetScope() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setScope("Scope");

    // Assert
    assertEquals("Scope", pdExportFormatAttributeObject.getScope());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#getSummary()}
   */
  @Test
  void testGetSummary() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getSummary());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#setSummary(String)}
   */
  @Test
  void testSetSummary() {
    // Arrange
    PDExportFormatAttributeObject pdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Act
    pdExportFormatAttributeObject.setSummary("Summary");

    // Assert
    assertEquals("Summary", pdExportFormatAttributeObject.getSummary());
    COSDictionary cOSObject = pdExportFormatAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExportFormatAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDExportFormatAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=Owner", (new PDExportFormatAttributeObject("Owner")).toString());
    assertEquals("O=null", (new PDExportFormatAttributeObject(new COSDictionary())).toString());
  }

  /**
   * Method under test:
   * {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDExportFormatAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDExportFormatAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)}
   */
  @Test
  void testNewPDExportFormatAttributeObject2() {
    // Arrange and Act
    PDExportFormatAttributeObject actualPdExportFormatAttributeObject = new PDExportFormatAttributeObject("Owner");

    // Assert
    assertEquals("Owner", actualPdExportFormatAttributeObject.getOwner());
    assertNull(actualPdExportFormatAttributeObject.getHeaders());
    assertNull(actualPdExportFormatAttributeObject.getBorderColors());
    assertNull(actualPdExportFormatAttributeObject.getBorderThickness());
    assertNull(actualPdExportFormatAttributeObject.getColumnGap());
    assertNull(actualPdExportFormatAttributeObject.getColumnWidths());
    assertNull(actualPdExportFormatAttributeObject.getScope());
    assertNull(actualPdExportFormatAttributeObject.getSummary());
    COSDictionary cOSObject = actualPdExportFormatAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdExportFormatAttributeObject.getBBox());
    assertNull(actualPdExportFormatAttributeObject.getBackgroundColor());
    assertNull(actualPdExportFormatAttributeObject.getColor());
    assertNull(actualPdExportFormatAttributeObject.getTextDecorationColor());
    assertEquals(-1.0f, actualPdExportFormatAttributeObject.getTextDecorationThickness());
    assertEquals(0.0f, ((Float) actualPdExportFormatAttributeObject.getPadding()).floatValue());
    assertEquals(0.0f, ((Float) actualPdExportFormatAttributeObject.getTPadding()).floatValue());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getBaselineShift());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getEndIndent());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getSpaceAfter());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getSpaceBefore());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getStartIndent());
    assertEquals(0.0f, actualPdExportFormatAttributeObject.getTextIndent());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, actualPdExportFormatAttributeObject.getColSpan());
    assertEquals(1, actualPdExportFormatAttributeObject.getRowSpan());
    assertEquals(1, actualPdExportFormatAttributeObject.getColumnCount());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdExportFormatAttributeObject.isEmpty());
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, actualPdExportFormatAttributeObject.getBlockAlign());
    assertEquals(PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, actualPdExportFormatAttributeObject.getRubyPosition());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdExportFormatAttributeObject.getListNumbering());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE,
        actualPdExportFormatAttributeObject.getTextDecorationType());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdExportFormatAttributeObject.getBorderStyle());
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdExportFormatAttributeObject.getTBorderStyle());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdExportFormatAttributeObject.getGlyphOrientationVertical());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdExportFormatAttributeObject.getHeight());
    assertEquals(PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdExportFormatAttributeObject.getWidth());
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdExportFormatAttributeObject.getInlineAlign());
    assertEquals(PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdExportFormatAttributeObject.getTextAlign());
    assertEquals(PDLayoutAttributeObject.LINE_HEIGHT_NORMAL, actualPdExportFormatAttributeObject.getLineHeight());
    assertEquals(PDLayoutAttributeObject.PLACEMENT_INLINE, actualPdExportFormatAttributeObject.getPlacement());
    assertEquals(PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE, actualPdExportFormatAttributeObject.getRubyAlign());
    assertEquals(PDLayoutAttributeObject.WRITING_MODE_LRTB, actualPdExportFormatAttributeObject.getWritingMode());
  }
}
