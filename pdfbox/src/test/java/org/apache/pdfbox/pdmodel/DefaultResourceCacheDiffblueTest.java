package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultResourceCacheDiffblueTest {
  /**
   * Test {@link DefaultResourceCache#getFont(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getFont(COSObject)}
   */
  @Test
  @DisplayName("Test getFont(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDFont DefaultResourceCache.getFont(COSObject)"})
  void testGetFont() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getFont(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link DefaultResourceCache#getColorSpace(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getColorSpace(COSObject)}
   */
  @Test
  @DisplayName("Test getColorSpace(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace DefaultResourceCache.getColorSpace(COSObject)"})
  void testGetColorSpace() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getColorSpace(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link DefaultResourceCache#getExtGState(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getExtGState(COSObject)}
   */
  @Test
  @DisplayName("Test getExtGState(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState DefaultResourceCache.getExtGState(COSObject)"})
  void testGetExtGState() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getExtGState(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link DefaultResourceCache#getShading(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getShading(COSObject)}
   */
  @Test
  @DisplayName("Test getShading(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.shading.PDShading DefaultResourceCache.getShading(COSObject)"})
  void testGetShading() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getShading(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link DefaultResourceCache#getPattern(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getPattern(COSObject)}
   */
  @Test
  @DisplayName("Test getPattern(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern DefaultResourceCache.getPattern(COSObject)"})
  void testGetPattern() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getPattern(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link DefaultResourceCache#getXObject(COSObject)}.
   * <p>
   * Method under test: {@link DefaultResourceCache#getXObject(COSObject)}
   */
  @Test
  @DisplayName("Test getXObject(COSObject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.PDXObject DefaultResourceCache.getXObject(COSObject)"})
  void testGetXObject() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();

    // Act and Assert
    assertNull(defaultResourceCache.getXObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }
}
