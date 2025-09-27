package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultResourceCacheDiffblueTest {
  /**
   * Test {@link DefaultResourceCache#getFont(COSObject)}.
   *
   * <p>Method under test: {@link DefaultResourceCache#getFont(COSObject)}
   */
  @Test
  @DisplayName("Test getFont(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont DefaultResourceCache.getFont(COSObject)"})
  void testGetFont() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDFont actualFont = defaultResourceCache.getFont(indirect);

    // Assert
    assertNull(actualFont);
  }

  /**
   * Test {@link DefaultResourceCache#getColorSpace(COSObject)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResourceCache#getColorSpace(COSObject)}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(COSObject); given COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace DefaultResourceCache.getColorSpace(COSObject)"})
  void testGetColorSpace_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull()
      throws IOException {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    defaultResourceCache.put(indirect, new PDMMType1Font(new COSDictionary()));
    COSObject indirect2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDColorSpace actualColorSpace = defaultResourceCache.getColorSpace(indirect2);

    // Assert
    assertNull(actualColorSpace);
  }

  /**
   * Test {@link DefaultResourceCache#getExtGState(COSObject)}.
   *
   * <p>Method under test: {@link DefaultResourceCache#getExtGState(COSObject)}
   */
  @Test
  @DisplayName("Test getExtGState(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState DefaultResourceCache.getExtGState(COSObject)"})
  void testGetExtGState() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDExtendedGraphicsState actualExtGState = defaultResourceCache.getExtGState(indirect);

    // Assert
    assertNull(actualExtGState);
  }

  /**
   * Test {@link DefaultResourceCache#getShading(COSObject)}.
   *
   * <p>Method under test: {@link DefaultResourceCache#getShading(COSObject)}
   */
  @Test
  @DisplayName("Test getShading(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading DefaultResourceCache.getShading(COSObject)"})
  void testGetShading() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDShading actualShading = defaultResourceCache.getShading(indirect);

    // Assert
    assertNull(actualShading);
  }

  /**
   * Test {@link DefaultResourceCache#getPattern(COSObject)}.
   *
   * <p>Method under test: {@link DefaultResourceCache#getPattern(COSObject)}
   */
  @Test
  @DisplayName("Test getPattern(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAbstractPattern DefaultResourceCache.getPattern(COSObject)"})
  void testGetPattern() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDAbstractPattern actualPattern = defaultResourceCache.getPattern(indirect);

    // Assert
    assertNull(actualPattern);
  }

  /**
   * Test {@link DefaultResourceCache#getProperties(COSObject)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultResourceCache#getProperties(COSObject)}
   */
  @Test
  @DisplayName("Test getProperties(COSObject); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList DefaultResourceCache.getProperties(COSObject)"})
  void testGetProperties_thenReturnNull() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDPropertyList actualProperties = defaultResourceCache.getProperties(indirect);

    // Assert
    assertNull(actualProperties);
  }

  /**
   * Test {@link DefaultResourceCache#getXObject(COSObject)}.
   *
   * <p>Method under test: {@link DefaultResourceCache#getXObject(COSObject)}
   */
  @Test
  @DisplayName("Test getXObject(COSObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDXObject DefaultResourceCache.getXObject(COSObject)"})
  void testGetXObject() {
    // Arrange
    DefaultResourceCache defaultResourceCache = new DefaultResourceCache();
    COSObject indirect = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    PDXObject actualXObject = defaultResourceCache.getXObject(indirect);

    // Assert
    assertNull(actualXObject);
  }
}
