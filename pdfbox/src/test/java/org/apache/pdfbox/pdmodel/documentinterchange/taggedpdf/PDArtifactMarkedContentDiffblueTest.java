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

class PDArtifactMarkedContentDiffblueTest {
  /**
   * Test {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)}.
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#PDArtifactMarkedContent(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDArtifactMarkedContent(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDArtifactMarkedContent.<init>(COSDictionary)"})
  void testNewPDArtifactMarkedContent() {
    // Arrange
    COSDictionary properties = new COSDictionary();

    // Act
    PDArtifactMarkedContent actualPdArtifactMarkedContent = new PDArtifactMarkedContent(properties);

    // Assert
    assertEquals("Artifact", actualPdArtifactMarkedContent.getTag());
    assertNull(actualPdArtifactMarkedContent.getActualText());
    assertNull(actualPdArtifactMarkedContent.getAlternateDescription());
    assertNull(actualPdArtifactMarkedContent.getExpandedForm());
    assertNull(actualPdArtifactMarkedContent.getLanguage());
    assertNull(actualPdArtifactMarkedContent.getSubtype());
    assertNull(actualPdArtifactMarkedContent.getType());
    assertNull(actualPdArtifactMarkedContent.getBBox());
    assertEquals(-1, actualPdArtifactMarkedContent.getMCID());
    assertFalse(actualPdArtifactMarkedContent.isBottomAttached());
    assertFalse(actualPdArtifactMarkedContent.isLeftAttached());
    assertFalse(actualPdArtifactMarkedContent.isRightAttached());
    assertFalse(actualPdArtifactMarkedContent.isTopAttached());
    assertTrue(actualPdArtifactMarkedContent.getContents().isEmpty());
    assertSame(properties, actualPdArtifactMarkedContent.getProperties());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getType()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDArtifactMarkedContent.getType()"})
  void testGetType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getBBox()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDArtifactMarkedContent.getBBox()"})
  void testGetBBox_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getBBox());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isTopAttached()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isTopAttached()}
   */
  @Test
  @DisplayName("Test isTopAttached(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDArtifactMarkedContent.isTopAttached()"})
  void testIsTopAttached_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isTopAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isBottomAttached()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isBottomAttached()}
   */
  @Test
  @DisplayName("Test isBottomAttached(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDArtifactMarkedContent.isBottomAttached()"})
  void testIsBottomAttached_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isBottomAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isLeftAttached()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isLeftAttached()}
   */
  @Test
  @DisplayName("Test isLeftAttached(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDArtifactMarkedContent.isLeftAttached()"})
  void testIsLeftAttached_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isLeftAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#isRightAttached()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#isRightAttached()}
   */
  @Test
  @DisplayName("Test isRightAttached(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDArtifactMarkedContent.isRightAttached()"})
  void testIsRightAttached_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDArtifactMarkedContent(new COSDictionary())).isRightAttached());
  }

  /**
   * Test {@link PDArtifactMarkedContent#getSubtype()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDArtifactMarkedContent#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDArtifactMarkedContent.getSubtype()"})
  void testGetSubtype_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDArtifactMarkedContent(new COSDictionary())).getSubtype());
  }
}
