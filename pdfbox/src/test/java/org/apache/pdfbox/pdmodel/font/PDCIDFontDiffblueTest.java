package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIDFontDiffblueTest {
  /**
   * Test {@link PDCIDFont#getCOSObject()}.
   * <p>
   * Method under test: {@link PDCIDFont#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDCIDFont.getCOSObject()"})
  void testGetCOSObject() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertSame(pdcidFontType0.dict, pdcidFontType0.getCOSObject());
  }

  /**
   * Test {@link PDCIDFont#getBaseFont()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCIDFont.getBaseFont()"})
  void testGetBaseFont_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getBaseFont());
  }

  /**
   * Test {@link PDCIDFont#getName()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCIDFont.getName()"})
  void testGetName_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getName());
  }

  /**
   * Test {@link PDCIDFont#getFontDescriptor()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDFontDescriptor PDCIDFont.getFontDescriptor()"})
  void testGetFontDescriptor_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getFontDescriptor());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDType0Font PDCIDFont.getParent()"})
  void testGetParent_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getParent());
  }

  /**
   * Test {@link PDCIDFont#getAverageFontWidth()}.
   * <ul>
   *   <li>Then return one thousand.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); then return one thousand")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCIDFont.getAverageFontWidth()"})
  void testGetAverageFontWidth_thenReturnOneThousand() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1000.0f, (new PDCIDFontType2(new COSDictionary(), null)).getAverageFontWidth());
  }

  /**
   * Test {@link PDCIDFont#getCIDSystemInfo()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#getCIDSystemInfo()}
   */
  @Test
  @DisplayName("Test getCIDSystemInfo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDCIDSystemInfo PDCIDFont.getCIDSystemInfo()"})
  void testGetCIDSystemInfo_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getCIDSystemInfo());
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).readCIDToGIDMap());
  }
}
