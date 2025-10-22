package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SCNToolTipDiffblueTest {
  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
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
   *   <li>Given {@link PDCalGray#PDCalGray()}.</li>
   *   <li>When {@link PDResources#PDResources()} add {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String); given PDCalGray(); when PDResources() add PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip_givenPDCalGray_whenPDResourcesAddPDCalGray() {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDCalGray());

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip_whenPDResources_thenReturnToolTipTextIsNull() {
    // Arrange, Act and Assert
    assertNull((new SCNToolTip(new PDResources(), "Color Space Name", "Row Text")).getToolTipText());
  }
}
