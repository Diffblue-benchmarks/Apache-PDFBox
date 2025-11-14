package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationFreeTextDiffblueTest {
  /**
   * Test {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFreeText(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.<init>(COSDictionary)"})
  void testNewFDFAnnotationFreeText() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationFreeText(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationFreeText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.<init>()"})
  void testNewFDFAnnotationFreeText2() throws IOException {
    // Arrange and Act
    FDFAnnotationFreeText actualFdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Assert
    assertEquals("", actualFdfAnnotationFreeText.getRichContents());
    assertEquals("0", actualFdfAnnotationFreeText.getJustification());
    assertNull(actualFdfAnnotationFreeText.getCallout());
    assertNull(actualFdfAnnotationFreeText.getColor());
    assertNull(actualFdfAnnotationFreeText.getPage());
    assertNull(actualFdfAnnotationFreeText.getContents());
    assertNull(actualFdfAnnotationFreeText.getDate());
    assertNull(actualFdfAnnotationFreeText.getIntent());
    assertNull(actualFdfAnnotationFreeText.getName());
    assertNull(actualFdfAnnotationFreeText.getSubject());
    assertNull(actualFdfAnnotationFreeText.getTitle());
    assertNull(actualFdfAnnotationFreeText.getDefaultAppearance());
    assertNull(actualFdfAnnotationFreeText.getDefaultStyle());
    assertNull(actualFdfAnnotationFreeText.getLineEndingStyle());
    assertNull(actualFdfAnnotationFreeText.getRotation());
    assertNull(actualFdfAnnotationFreeText.getCreationDate());
    assertNull(actualFdfAnnotationFreeText.getRectangle());
    assertNull(actualFdfAnnotationFreeText.getFringe());
    assertNull(actualFdfAnnotationFreeText.getBorderEffect());
    assertNull(actualFdfAnnotationFreeText.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationFreeText.getOpacity());
    assertFalse(actualFdfAnnotationFreeText.isHidden());
    assertFalse(actualFdfAnnotationFreeText.isInvisible());
    assertFalse(actualFdfAnnotationFreeText.isLocked());
    assertFalse(actualFdfAnnotationFreeText.isLockedContents());
    assertFalse(actualFdfAnnotationFreeText.isNoRotate());
    assertFalse(actualFdfAnnotationFreeText.isNoView());
    assertFalse(actualFdfAnnotationFreeText.isNoZoom());
    assertFalse(actualFdfAnnotationFreeText.isPrinted());
    assertFalse(actualFdfAnnotationFreeText.isReadOnly());
    assertFalse(actualFdfAnnotationFreeText.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationFreeText#FDFAnnotationFreeText(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#FDFAnnotationFreeText(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationFreeText(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.<init>(Element)"})
  void testNewFDFAnnotationFreeText_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationFreeText(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationFreeText#setCallout(float[])}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setCallout(float[])}
   */
  @Test
  @DisplayName(
      "Test setCallout(float[]); then FDFAnnotationFreeText() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setCallout(float[])"})
  void testSetCallout_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsFour() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setPage(4);

    // Act
    fdfAnnotationFreeText.setCallout(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f},
        fdfAnnotationFreeText.getCallout(),
        0.0f);
  }

  /**
   * Test {@link FDFAnnotationFreeText#setCallout(float[])}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setCallout(float[])}
   */
  @Test
  @DisplayName(
      "Test setCallout(float[]); then FDFAnnotationFreeText() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setCallout(float[])"})
  void testSetCallout_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setCallout(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName(
      "Test getCallout(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationFreeText.getCallout()"})
  void testGetCallout_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getCallout());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationFreeText.getCallout()"})
  void testGetCallout_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getCallout());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getCallout()}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout(); then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationFreeText.getCallout()"})
  void testGetCallout_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setCallout(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   *
   * <ul>
   *   <li>When {@code centered}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName(
      "Test setJustification(String); when 'centered'; then FDFAnnotationFreeText() Justification is '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setJustification(String)"})
  void testSetJustification_whenCentered_thenFDFAnnotationFreeTextJustificationIs1() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("centered");

    // Assert
    assertEquals("1", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   *
   * <ul>
   *   <li>When {@code Justification}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification is {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName(
      "Test setJustification(String); when 'Justification'; then FDFAnnotationFreeText() Justification is '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setJustification(String)"})
  void testSetJustification_whenJustification_thenFDFAnnotationFreeTextJustificationIs0() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("Justification");

    // Assert
    assertEquals("0", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setJustification(String)}.
   *
   * <ul>
   *   <li>When {@code right}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setJustification(String)}
   */
  @Test
  @DisplayName(
      "Test setJustification(String); when 'right'; then FDFAnnotationFreeText() Justification is '2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setJustification(String)"})
  void testSetJustification_whenRight_thenFDFAnnotationFreeTextJustificationIs2() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setJustification("right");

    // Assert
    assertEquals("2", fdfAnnotationFreeText.getJustification());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Justification is {@code
   *       Justification}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName(
      "Test getJustification(); given FDFAnnotationFreeText() Justification is 'Justification'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getJustification()"})
  void testGetJustification_givenFDFAnnotationFreeTextJustificationIsJustification() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setJustification("Justification");

    // Act and Assert
    assertEquals("0", fdfAnnotationFreeText.getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName(
      "Test getJustification(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getJustification()"})
  void testGetJustification_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", new FDFAnnotationFreeText(new COSDictionary()).getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getJustification()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getJustification()}
   */
  @Test
  @DisplayName("Test getJustification(); given FDFAnnotationFreeText(); then return '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getJustification()"})
  void testGetJustification_givenFDFAnnotationFreeText_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", new FDFAnnotationFreeText().getJustification());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setRotation(int)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); then FDFAnnotationFreeText() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setRotation(int)"})
  void testSetRotation_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setRotation(1);

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setRotation(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int); when MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setRotation(int)"})
  void testSetRotation_whenMin_value() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setRotation(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getRotation()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getRotation()}
   */
  @Test
  @DisplayName(
      "Test getRotation(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getRotation()"})
  void testGetRotation_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getRotation());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getRotation()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getRotation()"})
  void testGetRotation_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getRotation());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultAppearance(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearance(String); then FDFAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultAppearance(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultAppearance(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} DefaultAppearance is {@code
   *       Appearance}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearance(String); then FDFAnnotationFreeText() DefaultAppearance is 'Appearance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_thenFDFAnnotationFreeTextDefaultAppearanceIsAppearance() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultAppearance("Appearance");

    // Assert
    assertEquals("Appearance", fdfAnnotationFreeText.getDefaultAppearance());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDefaultAppearance(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultAppearance()"})
  void testGetDefaultAppearance_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code Appearance}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return 'Appearance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturnAppearance() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultAppearance("Appearance");

    // Act and Assert
    assertEquals("Appearance", fdfAnnotationFreeText.getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance(); then return ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultAppearance()"})
  void testGetDefaultAppearance_thenReturnComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultAppearance(",");

    // Act and Assert
    assertEquals(",", fdfAnnotationFreeText.getDefaultAppearance());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} DefaultStyle is {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setDefaultStyle(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyle(String); then FDFAnnotationFreeText() DefaultStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setDefaultStyle(String)"})
  void testSetDefaultStyle_thenFDFAnnotationFreeTextDefaultStyleIsStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationFreeText.getDefaultStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setDefaultStyle(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setDefaultStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultStyle(String); when 'null'; then FDFAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setDefaultStyle(String)"})
  void testSetDefaultStyle_whenNull_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setDefaultStyle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName(
      "Test getDefaultStyle(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultStyle()"})
  void testGetDefaultStyle_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultStyle()"})
  void testGetDefaultStyle_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   *
   * <ul>
   *   <li>Then return {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); then return ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultStyle()"})
  void testGetDefaultStyle_thenReturnComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultStyle(",");

    // Act and Assert
    assertEquals(",", fdfAnnotationFreeText.getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getDefaultStyle()}.
   *
   * <ul>
   *   <li>Then return {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getDefaultStyle()}
   */
  @Test
  @DisplayName("Test getDefaultStyle(); then return 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getDefaultStyle()"})
  void testGetDefaultStyle_thenReturnStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setDefaultStyle("Style");

    // Act and Assert
    assertEquals("Style", fdfAnnotationFreeText.getDefaultStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject toIncrement Objects
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); then FDFAnnotationFreeText() COSObject toIncrement Objects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setFringe(PDRectangle)"})
  void testSetFringe_thenFDFAnnotationFreeTextCOSObjectToIncrementObjectsSizeIsOne() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setFringe(PDRectangle.LETTER);

    // Assert
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(1, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    PDRectangle fringe = fdfAnnotationFreeText.getFringe();
    assertEquals(792.0f, fringe.getHeight());
    assertEquals(612.0f, fringe.getUpperRightX());
    assertEquals(792.0f, fringe.getUpperRightY());
    assertEquals(612.0f, fringe.getWidth());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} Fringe UpperRightX is {@code
   *       2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); when A0; then FDFAnnotationFreeText() Fringe UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setFringe(PDRectangle)"})
  void testSetFringe_whenA0_thenFDFAnnotationFreeTextFringeUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationFreeText.getFringe();
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject toIncrement Objects
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); when 'null'; then FDFAnnotationFreeText() COSObject toIncrement Objects Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setFringe(PDRectangle)"})
  void testSetFringe_whenNull_thenFDFAnnotationFreeTextCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setFringe(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = fdfAnnotationFreeText.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName(
      "Test getFringe(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationFreeText.getFringe()"})
  void testGetFringe_givenFDFAnnotationFreeTextWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getFringe());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationFreeText.getFringe()"})
  void testGetFringe_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getFringe());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationFreeText.getFringe()"})
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationFreeText.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualFringe.getLowerLeftX());
    assertEquals(0.0f, actualFringe.getLowerLeftY());
    assertEquals(2383.937f, actualFringe.getUpperRightX());
    assertEquals(2383.937f, actualFringe.getWidth());
    assertEquals(3370.3938f, actualFringe.getHeight());
    assertEquals(3370.3938f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getFringe()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationFreeText.getFringe()"})
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    PDRectangle fringe =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fdfAnnotationFreeText.setFringe(fringe);

    // Act
    PDRectangle actualFringe = fdfAnnotationFreeText.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFringe.getHeight());
    assertEquals(0.0f, actualFringe.getWidth());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightX());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link FDFAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); then FDFAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_thenFDFAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setLineEndingStyle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} LineEndingStyle is {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); when ','; then FDFAnnotationFreeText() LineEndingStyle is ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_whenComma_thenFDFAnnotationFreeTextLineEndingStyleIsComma() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setLineEndingStyle(",");

    // Assert
    assertEquals(",", fdfAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code Style}.
   *   <li>Then {@link FDFAnnotationFreeText#FDFAnnotationFreeText()} LineEndingStyle is {@code
   *       Style}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); when 'Style'; then FDFAnnotationFreeText() LineEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_whenStyle_thenFDFAnnotationFreeTextLineEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();

    // Act
    fdfAnnotationFreeText.setLineEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = fdfAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName(
      "Test getLineEndingStyle(); given FDFAnnotationFreeText(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getLineEndingStyle()"})
  void testGetLineEndingStyle_givenFDFAnnotationFreeTextWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText(new COSDictionary()).getLineEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationFreeText#FDFAnnotationFreeText()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle(); given FDFAnnotationFreeText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getLineEndingStyle()"})
  void testGetLineEndingStyle_givenFDFAnnotationFreeText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationFreeText().getLineEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationFreeText#getLineEndingStyle()}.
   *
   * <ul>
   *   <li>Then return {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle(); then return 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationFreeText.getLineEndingStyle()"})
  void testGetLineEndingStyle_thenReturnStyle() {
    // Arrange
    FDFAnnotationFreeText fdfAnnotationFreeText = new FDFAnnotationFreeText();
    fdfAnnotationFreeText.setLineEndingStyle("Style");

    // Act and Assert
    assertEquals("Style", fdfAnnotationFreeText.getLineEndingStyle());
  }
}
