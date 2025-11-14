package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType1;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingPatternDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDShadingPattern#PDShadingPattern(COSDictionary)}
   *   <li>{@link PDShadingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDShadingPattern.<init>(COSDictionary)",
    "int PDShadingPattern.getPatternType()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern(resourceDictionary);

    // Assert
    assertEquals(2, actualPdShadingPattern.getPatternType());
    assertSame(resourceDictionary, actualPdShadingPattern.getCOSObject());
  }

  /**
   * Test {@link PDShadingPattern#PDShadingPattern()}.
   *
   * <p>Method under test: {@link PDShadingPattern#PDShadingPattern()}
   */
  @Test
  @DisplayName("Test new PDShadingPattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.<init>()"})
  void testNewPDShadingPattern() throws IOException {
    // Arrange and Act
    PDShadingPattern actualPdShadingPattern = new PDShadingPattern();

    // Assert
    assertEquals("Pattern", actualPdShadingPattern.getType());
    COSDictionary cOSObject = actualPdShadingPattern.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdShadingPattern.getShading());
    assertNull(actualPdShadingPattern.getExtendedGraphicsState());
    Matrix matrix = actualPdShadingPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, actualPdShadingPattern.getPatternType());
    assertEquals(3, matrix.getValues().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   *
   * <p>Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDShadingPattern.getExtendedGraphicsState()"})
  void testGetExtendedGraphicsState() {
    // Arrange, Act and Assert
    assertNull(new PDShadingPattern(new COSDictionary()).getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState(); given PDShadingPattern(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDShadingPattern.getExtendedGraphicsState()"})
  void testGetExtendedGraphicsState_givenPDShadingPattern_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDShadingPattern().getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#getExtendedGraphicsState()}.
   *
   * <ul>
   *   <li>Then return {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#getExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test getExtendedGraphicsState(); then return PDExtendedGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExtendedGraphicsState PDShadingPattern.getExtendedGraphicsState()"})
  void testGetExtendedGraphicsState_thenReturnPDExtendedGraphicsState() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Act and Assert
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   *
   * <p>Method under test: {@link
   * PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName("Test setExtendedGraphicsState(PDExtendedGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setExtendedGraphicsState(PDExtendedGraphicsState)"})
  void testSetExtendedGraphicsState() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test setExtendedGraphicsState(PDExtendedGraphicsState); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setExtendedGraphicsState(PDExtendedGraphicsState)"})
  void testSetExtendedGraphicsState_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState(dictionary);

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test setExtendedGraphicsState(PDExtendedGraphicsState); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setExtendedGraphicsState(PDExtendedGraphicsState)"})
  void testSetExtendedGraphicsState_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);
    PDExtendedGraphicsState extendedGraphicsState = new PDExtendedGraphicsState(dictionary);

    // Act
    pdShadingPattern.setExtendedGraphicsState(extendedGraphicsState);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(extendedGraphicsState, pdShadingPattern.getExtendedGraphicsState());
  }

  /**
   * Test {@link PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDShadingPattern#setExtendedGraphicsState(PDExtendedGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test setExtendedGraphicsState(PDExtendedGraphicsState); then PDShadingPattern() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setExtendedGraphicsState(PDExtendedGraphicsState)"})
  void testSetExtendedGraphicsState_thenPDShadingPatternCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setExtendedGraphicsState(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern(COSDictionary)} with resourceDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName(
      "Test getShading(); given PDShadingPattern(COSDictionary) with resourceDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDShadingPattern.getShading()"})
  void testGetShading_givenPDShadingPatternWithResourceDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDShadingPattern(new COSDictionary()).getShading());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingPattern#PDShadingPattern()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName("Test getShading(); given PDShadingPattern(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDShadingPattern.getShading()"})
  void testGetShading_givenPDShadingPattern_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDShadingPattern().getShading());
  }

  /**
   * Test {@link PDShadingPattern#getShading()}.
   *
   * <ul>
   *   <li>Then return {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary
   *       is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#getShading()}
   */
  @Test
  @DisplayName(
      "Test getShading(); then return PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDShadingPattern.getShading()"})
  void testGetShading_thenReturnPDShadingType1WithShadingDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());
    pdShadingPattern.setShading(shadingResources);

    // Act and Assert
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName(
      "Test setShading(PDShading); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setShading(PDShading)"})
  void testSetShading_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setShading(PDShading)"})
  void testSetShading_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);
    PDShadingType1 shadingResources = new PDShadingType1(shadingDictionary);

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   *
   * <ul>
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName("Test setShading(PDShading); then PDShadingPattern() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setShading(PDShading)"})
  void testSetShading_thenPDShadingPatternCOSObjectValuesSizeIsThree() throws IOException {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();
    PDShadingType1 shadingResources = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingPattern.setShading(shadingResources);

    // Assert
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(shadingResources, pdShadingPattern.getShading());
  }

  /**
   * Test {@link PDShadingPattern#setShading(PDShading)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDShadingPattern#PDShadingPattern()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDShadingPattern#setShading(PDShading)}
   */
  @Test
  @DisplayName(
      "Test setShading(PDShading); when 'null'; then PDShadingPattern() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShadingPattern.setShading(PDShading)"})
  void testSetShading_whenNull_thenPDShadingPatternCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDShadingPattern pdShadingPattern = new PDShadingPattern();

    // Act
    pdShadingPattern.setShading(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingPattern.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
