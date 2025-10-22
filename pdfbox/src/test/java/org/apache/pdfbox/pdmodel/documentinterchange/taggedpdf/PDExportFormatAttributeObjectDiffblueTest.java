package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDExportFormatAttributeObjectDiffblueTest {
  /**
   * Test {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(COSDictionary)}.
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDExportFormatAttributeObject(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.<init>(COSDictionary)"})
  void testNewPDExportFormatAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDExportFormatAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)}.
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)}
   */
  @Test
  @DisplayName("Test new PDExportFormatAttributeObject(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.<init>(String)"})
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
    assertEquals(1, actualPdExportFormatAttributeObject.getColSpan());
    assertEquals(1, actualPdExportFormatAttributeObject.getRowSpan());
    assertEquals(1, actualPdExportFormatAttributeObject.getColumnCount());
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

  /**
   * Test {@link PDExportFormatAttributeObject#getListNumbering()}.
   * <ul>
   *   <li>Then return {@link PDLayoutAttributeObject#BORDER_STYLE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getListNumbering()}
   */
  @Test
  @DisplayName("Test getListNumbering(); then return BORDER_STYLE_NONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDExportFormatAttributeObject.getListNumbering()"})
  void testGetListNumbering_thenReturnBorder_style_none() {
    // Arrange, Act and Assert
    assertEquals(PDLayoutAttributeObject.BORDER_STYLE_NONE,
        (new PDExportFormatAttributeObject("Owner")).getListNumbering());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setListNumbering(String)}.
   * <ul>
   *   <li>Then {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner} ListNumbering is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setListNumbering(String)}
   */
  @Test
  @DisplayName("Test setListNumbering(String); then PDExportFormatAttributeObject(String) with 'Owner' ListNumbering is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setListNumbering(String)"})
  void testSetListNumbering_thenPDExportFormatAttributeObjectWithOwnerListNumberingIs42() {
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
   * Test {@link PDExportFormatAttributeObject#getRowSpan()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getRowSpan()}
   */
  @Test
  @DisplayName("Test getRowSpan(); given PDExportFormatAttributeObject(String) with 'Owner'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDExportFormatAttributeObject.getRowSpan()"})
  void testGetRowSpan_givenPDExportFormatAttributeObjectWithOwner_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDExportFormatAttributeObject("Owner")).getRowSpan());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setRowSpan(int)}.
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setRowSpan(int)}
   */
  @Test
  @DisplayName("Test setRowSpan(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setRowSpan(int)"})
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
   * Test {@link PDExportFormatAttributeObject#getColSpan()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getColSpan()}
   */
  @Test
  @DisplayName("Test getColSpan(); given PDExportFormatAttributeObject(String) with 'Owner'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDExportFormatAttributeObject.getColSpan()"})
  void testGetColSpan_givenPDExportFormatAttributeObjectWithOwner_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDExportFormatAttributeObject("Owner")).getColSpan());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setColSpan(int)}.
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setColSpan(int)}
   */
  @Test
  @DisplayName("Test setColSpan(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setColSpan(int)"})
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
   * Test {@link PDExportFormatAttributeObject#getHeaders()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getHeaders()}
   */
  @Test
  @DisplayName("Test getHeaders(); given PDExportFormatAttributeObject(String) with 'Owner'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] PDExportFormatAttributeObject.getHeaders()"})
  void testGetHeaders_givenPDExportFormatAttributeObjectWithOwner_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getHeaders());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setHeaders(String[])}.
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setHeaders(String[])}
   */
  @Test
  @DisplayName("Test setHeaders(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setHeaders(String[])"})
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
   * Test {@link PDExportFormatAttributeObject#getScope()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getScope()}
   */
  @Test
  @DisplayName("Test getScope(); given PDExportFormatAttributeObject(String) with 'Owner'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDExportFormatAttributeObject.getScope()"})
  void testGetScope_givenPDExportFormatAttributeObjectWithOwner_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getScope());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setScope(String)}.
   * <ul>
   *   <li>Then {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner} Scope is {@code Scope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setScope(String)}
   */
  @Test
  @DisplayName("Test setScope(String); then PDExportFormatAttributeObject(String) with 'Owner' Scope is 'Scope'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setScope(String)"})
  void testSetScope_thenPDExportFormatAttributeObjectWithOwnerScopeIsScope() {
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
   * Test {@link PDExportFormatAttributeObject#getSummary()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#getSummary()}
   */
  @Test
  @DisplayName("Test getSummary(); given PDExportFormatAttributeObject(String) with 'Owner'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDExportFormatAttributeObject.getSummary()"})
  void testGetSummary_givenPDExportFormatAttributeObjectWithOwner_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDExportFormatAttributeObject("Owner")).getSummary());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#setSummary(String)}.
   * <ul>
   *   <li>Then {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner} Summary is {@code Summary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#setSummary(String)}
   */
  @Test
  @DisplayName("Test setSummary(String); then PDExportFormatAttributeObject(String) with 'Owner' Summary is 'Summary'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDExportFormatAttributeObject.setSummary(String)"})
  void testSetSummary_thenPDExportFormatAttributeObjectWithOwnerSummaryIsSummary() {
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
   * Test {@link PDExportFormatAttributeObject#toString()}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   *   <li>Then return {@code O=Owner}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDExportFormatAttributeObject(String) with 'Owner'; then return 'O=Owner'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDExportFormatAttributeObject.toString()"})
  void testToString_givenPDExportFormatAttributeObjectWithOwner_thenReturnOOwner() {
    // Arrange, Act and Assert
    assertEquals("O=Owner", (new PDExportFormatAttributeObject("Owner")).toString());
  }

  /**
   * Test {@link PDExportFormatAttributeObject#toString()}.
   * <ul>
   *   <li>Then return {@code O=null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDExportFormatAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDExportFormatAttributeObject.toString()"})
  void testToString_thenReturnONull() {
    // Arrange, Act and Assert
    assertEquals("O=null", (new PDExportFormatAttributeObject(new COSDictionary())).toString());
  }
}
