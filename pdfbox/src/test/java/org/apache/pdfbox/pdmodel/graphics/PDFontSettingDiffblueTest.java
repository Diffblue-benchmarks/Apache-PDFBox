package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFontSettingDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFontSetting#PDFontSetting(COSArray)}
   *   <li>{@link PDFontSetting#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFontSetting.<init>(COSArray)", "COSBase PDFontSetting.getCOSObject()"})
  void testGettersAndSetters() {
    // Arrange
    COSArray fs = new COSArray();

    // Act
    COSBase actualCOSObject = (new PDFontSetting(fs)).getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSArray);
    assertSame(fs, actualCOSObject);
  }

  /**
   * Test {@link PDFontSetting#PDFontSetting()}.
   * <p>
   * Method under test: {@link PDFontSetting#PDFontSetting()}
   */
  @Test
  @DisplayName("Test new PDFontSetting()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFontSetting.<init>()"})
  void testNewPDFontSetting() throws IOException {
    // Arrange and Act
    PDFontSetting actualPdFontSetting = new PDFontSetting();

    // Assert
    COSBase cOSObject = actualPdFontSetting.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertNull(actualPdFontSetting.getFont());
    assertEquals(1.0f, actualPdFontSetting.getFontSize());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDFontSetting#getFont()}.
   * <ul>
   *   <li>Given {@link PDFontSetting#PDFontSetting()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  @DisplayName("Test getFont(); given PDFontSetting(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDFontSetting.getFont()"})
  void testGetFont_givenPDFontSetting_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDFontSetting()).getFont());
  }

  /**
   * Test {@link PDFontSetting#getFont()}.
   * <ul>
   *   <li>Then return {@link PDType1Font}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  @DisplayName("Test getFont(); then return PDType1Font")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDFontSetting.getFont()"})
  void testGetFont_thenReturnPDType1Font() throws IOException {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    pdFontSetting.setFont(font);

    // Act
    PDFont actualFont = pdFontSetting.getFont();

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    assertEquals(font, actualFont);
  }

  /**
   * Test {@link PDFontSetting#setFont(PDFont)}.
   * <ul>
   *   <li>Given {@link PDFontSetting#PDFontSetting()}.</li>
   *   <li>Then {@link PDFontSetting#PDFontSetting()} Font {@link PDType1Font}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#setFont(PDFont)}
   */
  @Test
  @DisplayName("Test setFont(PDFont); given PDFontSetting(); then PDFontSetting() Font PDType1Font")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFontSetting.setFont(PDFont)"})
  void testSetFont_givenPDFontSetting_thenPDFontSettingFontPDType1Font() throws IOException {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());

    // Act
    pdFontSetting.setFont(font);

    // Assert
    PDFont font2 = pdFontSetting.getFont();
    assertTrue(font2 instanceof PDType1Font);
    assertEquals(font, font2);
  }

  /**
   * Test {@link PDFontSetting#setFont(PDFont)}.
   * <ul>
   *   <li>Given {@link PDFontSetting#PDFontSetting()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDFontSetting#PDFontSetting()} Font is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#setFont(PDFont)}
   */
  @Test
  @DisplayName("Test setFont(PDFont); given PDFontSetting(); when 'null'; then PDFontSetting() Font is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFontSetting.setFont(PDFont)"})
  void testSetFont_givenPDFontSetting_whenNull_thenPDFontSettingFontIsNull() throws IOException {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();

    // Act
    pdFontSetting.setFont(null);

    // Assert that nothing has changed
    assertNull(pdFontSetting.getFont());
  }

  /**
   * Test {@link PDFontSetting#getFontSize()}.
   * <ul>
   *   <li>Given {@link PDFontSetting#PDFontSetting()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#getFontSize()}
   */
  @Test
  @DisplayName("Test getFontSize(); given PDFontSetting(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFontSetting.getFontSize()"})
  void testGetFontSize_givenPDFontSetting_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDFontSetting()).getFontSize());
  }

  /**
   * Test {@link PDFontSetting#setFontSize(float)}.
   * <ul>
   *   <li>Given {@link PDFontSetting#PDFontSetting()}.</li>
   *   <li>Then {@link PDFontSetting#PDFontSetting()} FontSize is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFontSetting#setFontSize(float)}
   */
  @Test
  @DisplayName("Test setFontSize(float); given PDFontSetting(); then PDFontSetting() FontSize is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFontSetting.setFontSize(float)"})
  void testSetFontSize_givenPDFontSetting_thenPDFontSettingFontSizeIsTen() {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();

    // Act
    pdFontSetting.setFontSize(10.0f);

    // Assert
    assertEquals(10.0f, pdFontSetting.getFontSize());
  }
}
