package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDCIDFontDiffblueTest {
  /**
   * Test {@link PDCIDFont#getCOSObject()}.
   * <p>
   * Method under test: {@link PDCIDFont#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertSame(pdcidFontType0.dict, pdcidFontType0.getCOSObject());
  }

  /**
   * Test {@link PDCIDFont#getBaseFont()}.
   * <p>
   * Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont()")
  void testGetBaseFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getBaseFont());
  }

  /**
   * Test {@link PDCIDFont#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   * with fontDictionary is {@link COSStream#COSStream()} and parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSStream() and parent is 'null'")
  void testGetBaseFont_givenPDCIDFontType0WithFontDictionaryIsCOSStreamAndParentIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSStream(), null)).getBaseFont());
  }

  /**
   * Test {@link PDCIDFont#getName()}.
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   * with fontDictionary is {@link COSDictionary#COSDictionary()} and parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSDictionary() and parent is 'null'")
  void testGetName_givenPDCIDFontType0WithFontDictionaryIsCOSDictionaryAndParentIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getName());
  }

  /**
   * Test {@link PDCIDFont#getName()}.
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   * with fontDictionary is {@link COSStream#COSStream()} and parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSStream() and parent is 'null'")
  void testGetName_givenPDCIDFontType0WithFontDictionaryIsCOSStreamAndParentIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSStream(), null)).getName());
  }

  /**
   * Test {@link PDCIDFont#getFontDescriptor()}.
   * <p>
   * Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor()")
  void testGetFontDescriptor() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getFontDescriptor());
    assertNull((new PDCIDFontType0(new COSStream(), null)).getFontDescriptor());
  }

  /**
   * Test {@link PDCIDFont#getParent()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); then return 'null'")
  void testGetParent_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getParent());
  }

  /**
   * Test {@link PDCIDFont#getAverageFontWidth()}.
   * <p>
   * Method under test: {@link PDCIDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1000.0f, (new PDCIDFontType2(new COSDictionary(), null)).getAverageFontWidth());
    assertEquals(1000.0f, (new PDCIDFontType2(new COSStream(), null)).getAverageFontWidth());
  }

  /**
   * Test {@link PDCIDFont#getCIDSystemInfo()}.
   * <p>
   * Method under test: {@link PDCIDFont#getCIDSystemInfo()}
   */
  @Test
  @DisplayName("Test getCIDSystemInfo()")
  void testGetCIDSystemInfo() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getCIDSystemInfo());
    assertNull((new PDCIDFontType0(new COSStream(), null)).getCIDSystemInfo());
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   * <p>
   * Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  void testReadCIDToGIDMap() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).readCIDToGIDMap());
    assertNull((new PDCIDFontType0(new COSStream(), null)).readCIDToGIDMap());
  }
}
