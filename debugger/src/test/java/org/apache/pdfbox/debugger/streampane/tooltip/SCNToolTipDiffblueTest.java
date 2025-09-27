package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName("Test new SCNToolTip(PDResources, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources resources = new PDResources(resourceDictionary, new DefaultResourceCache());

    // Act
    SCNToolTip actualScnToolTip = new SCNToolTip(resources, "Color Space Name", "Row Text");

    // Assert
    assertNull(actualScnToolTip.getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   *
   * <ul>
   *   <li>Given {@link PDCalGray#PDCalGray()}.
   *   <li>When {@link PDResources#PDResources()} add {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SCNToolTip(PDResources, String, String); given PDCalGray(); when PDResources() add PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip_givenPDCalGray_whenPDResourcesAddPDCalGray() {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDCalGray());

    // Act
    SCNToolTip actualScnToolTip = new SCNToolTip(resources, "Color Space Name", "Row Text");

    // Assert
    assertNull(actualScnToolTip.getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   *
   * <ul>
   *   <li>When {@link PDResources#PDResources(COSDictionary)} with resourceDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SCNToolTip(PDResources, String, String); when PDResources(COSDictionary) with resourceDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip_whenPDResourcesWithResourceDictionaryIsCOSDictionary() {
    // Arrange and Act
    SCNToolTip actualScnToolTip =
        new SCNToolTip(new PDResources(new COSDictionary()), "Color Space Name", "Row Text");

    // Assert
    assertNull(actualScnToolTip.getToolTipText());
  }

  /**
   * Test {@link SCNToolTip#SCNToolTip(PDResources, String, String)}.
   *
   * <ul>
   *   <li>When {@link PDResources#PDResources()}.
   *   <li>Then return ToolTipText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SCNToolTip#SCNToolTip(PDResources, String, String)}
   */
  @Test
  @DisplayName(
      "Test new SCNToolTip(PDResources, String, String); when PDResources(); then return ToolTipText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SCNToolTip.<init>(PDResources, String, String)"})
  void testNewSCNToolTip_whenPDResources_thenReturnToolTipTextIsNull() {
    // Arrange and Act
    SCNToolTip actualScnToolTip = new SCNToolTip(new PDResources(), "Color Space Name", "Row Text");

    // Assert
    assertNull(actualScnToolTip.getToolTipText());
  }
}
