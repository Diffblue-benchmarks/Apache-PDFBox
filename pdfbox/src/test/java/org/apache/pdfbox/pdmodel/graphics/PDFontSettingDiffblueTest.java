package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.jupiter.api.Test;

class PDFontSettingDiffblueTest {
  /**
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  void testGetFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDFontSetting()).getFont());
  }

  /**
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  void testGetFont2() throws IOException {
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
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  void testGetFont3() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray fs = new COSArray();
    fs.add(object);

    // Act
    PDFont actualFont = (new PDFontSetting(fs)).getFont();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualFont);
  }

  /**
   * Method under test: {@link PDFontSetting#getFont()}
   */
  @Test
  void testGetFont4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray fs = new COSArray();
    fs.add(object);

    // Act
    PDFont actualFont = (new PDFontSetting(fs)).getFont();

    // Assert
    verify(object).getCOSObject();
    assertNull(actualFont);
  }

  /**
   * Method under test: {@link PDFontSetting#setFont(PDFont)}
   */
  @Test
  void testSetFont() throws IOException {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();
    COSDictionary fontDictionary = new COSDictionary();
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    // Act
    pdFontSetting.setFont(font);

    // Assert
    COSBase cOSObject = pdFontSetting.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDFont font2 = pdFontSetting.getFont();
    assertTrue(font2 instanceof PDType1Font);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertEquals(font, font2);
    assertSame(fontDictionary, toListResult.get(0));
  }

  /**
   * Method under test: {@link PDFontSetting#setFont(PDFont)}
   */
  @Test
  void testSetFont2() throws IOException {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();

    // Act
    pdFontSetting.setFont(null);

    // Assert
    COSBase cOSObject = pdFontSetting.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(pdFontSetting.getFont());
  }

  /**
   * Method under test: {@link PDFontSetting#getFontSize()}
   */
  @Test
  void testGetFontSize() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDFontSetting()).getFontSize());
  }

  /**
   * Method under test: {@link PDFontSetting#setFontSize(float)}
   */
  @Test
  void testSetFontSize() {
    // Arrange
    PDFontSetting pdFontSetting = new PDFontSetting();

    // Act
    pdFontSetting.setFontSize(10.0f);

    // Assert
    assertEquals(10.0f, pdFontSetting.getFontSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFontSetting#PDFontSetting(COSArray)}
   *   <li>{@link PDFontSetting#getCOSObject()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link PDFontSetting#PDFontSetting()}
   */
  @Test
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
}
