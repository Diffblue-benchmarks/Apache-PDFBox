package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.junit.jupiter.api.Test;

class SCNToolTipDiffblueTest {
  /**
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  void testNewSCNToolTip() {
    // Arrange, Act and Assert
    assertNull((new SCNToolTip(new PDResources(), "Color Space Name", "Row Text")).getToolTipText());
  }

  /**
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  void testNewSCNToolTip2() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new SCNToolTip(new PDResources(resourceDictionary, new DefaultResourceCache()), "Color Space Name",
        "Row Text")).getToolTipText());
  }

  /**
   * Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  void testNewSCNToolTip3() {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDCalGray());

    // Act and Assert
    assertNull((new SCNToolTip(resources, "Color Space Name", "Row Text")).getToolTipText());
  }
}
