package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SCNToolTipDiffblueTest {
  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String)")
  void testNewSCNToolTip() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new SCNToolTip(new PDResources(resourceDictionary, new DefaultResourceCache()), "Color Space Name",
        "Row Text")).getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PDResources#PDResources()} add {@code null}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); given 'null'; when PDResources() add 'null'; then return ToolTipText is 'null'")
  void testNewSCNToolTip_givenNull_whenPDResourcesAddNull_thenReturnToolTipTextIsNull() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add((PDColorSpace) null);
    resources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull((new SCNToolTip(resources, "Color Space Name", "Row Text")).getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>When {@link PDResources#PDResources()} add
   * {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); given PDCalGray(); when PDResources() add PDCalGray()")
  void testNewSCNToolTip_givenPDCalGray_whenPDResourcesAddPDCalGray() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDCalGray());
    resources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull((new SCNToolTip(resources, "Color Space Name", "Row Text")).getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <ul>
   *   <li>Given {@link PDFormXObject#PDFormXObject(COSStream)} with stream is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); given PDFormXObject(COSStream) with stream is COSStream()")
  void testNewSCNToolTip_givenPDFormXObjectWithStreamIsCOSStream() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDFormXObject(new COSStream()));
    resources.add(new PDMMType1Font(new COSDictionary()));
    resources.add(new PDCalGray());
    resources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull((new SCNToolTip(resources, "Color Space Name", "Row Text")).getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testNewSCNToolTip_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull((new SCNToolTip(resources, "Color Space Name", "Row Text")).getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <ul>
   *   <li>When {@link PDResources#PDResources()}.</li>
   *   <li>Then return ToolTipText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); when PDResources(); then return ToolTipText is 'null'")
  void testNewSCNToolTip_whenPDResources_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new SCNToolTip(new PDResources(), "Color Space Name", "Row Text")).getToolTipText());
  }
}
