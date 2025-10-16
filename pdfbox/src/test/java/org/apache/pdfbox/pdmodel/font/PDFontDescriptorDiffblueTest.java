package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFontDescriptorDiffblueTest {
  /**
   * Test {@link PDFontDescriptor#PDFontDescriptor(COSDictionary)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#PDFontDescriptor(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDFontDescriptor(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.<init>(COSDictionary)"})
  void testNewPDFontDescriptor() {
    // Arrange
    COSDictionary desc = new COSDictionary();

    // Act and Assert
    assertSame(desc, new PDFontDescriptor(desc).getCOSObject());
  }

  /**
   * Test {@link PDFontDescriptor#PDFontDescriptor()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#PDFontDescriptor()}
   */
  @Test
  @DisplayName("Test new PDFontDescriptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.<init>()"})
  void testNewPDFontDescriptor2() {
    // Arrange and Act
    PDFontDescriptor actualPdFontDescriptor = new PDFontDescriptor();

    // Assert
    assertNull(actualPdFontDescriptor.getCharSet());
    assertNull(actualPdFontDescriptor.getFontFamily());
    assertNull(actualPdFontDescriptor.getFontName());
    assertNull(actualPdFontDescriptor.getFontStretch());
    assertNull(actualPdFontDescriptor.getFontBoundingBox());
    assertNull(actualPdFontDescriptor.getCIDSet());
    assertNull(actualPdFontDescriptor.getFontFile());
    assertNull(actualPdFontDescriptor.getFontFile2());
    assertNull(actualPdFontDescriptor.getFontFile3());
    assertNull(actualPdFontDescriptor.getPanose());
    assertEquals(0, actualPdFontDescriptor.getFlags());
    assertEquals(0.0f, actualPdFontDescriptor.getAscent());
    assertEquals(0.0f, actualPdFontDescriptor.getAverageWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getCapHeight());
    assertEquals(0.0f, actualPdFontDescriptor.getDescent());
    assertEquals(0.0f, actualPdFontDescriptor.getFontWeight());
    assertEquals(0.0f, actualPdFontDescriptor.getItalicAngle());
    assertEquals(0.0f, actualPdFontDescriptor.getLeading());
    assertEquals(0.0f, actualPdFontDescriptor.getMaxWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getMissingWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getStemH());
    assertEquals(0.0f, actualPdFontDescriptor.getStemV());
    assertEquals(0.0f, actualPdFontDescriptor.getXHeight());
    assertFalse(actualPdFontDescriptor.isAllCap());
    assertFalse(actualPdFontDescriptor.isFixedPitch());
    assertFalse(actualPdFontDescriptor.isForceBold());
    assertFalse(actualPdFontDescriptor.isItalic());
    assertFalse(actualPdFontDescriptor.isNonSymbolic());
    assertFalse(actualPdFontDescriptor.isScript());
    assertFalse(actualPdFontDescriptor.isSerif());
    assertFalse(actualPdFontDescriptor.isSmallCap());
    assertFalse(actualPdFontDescriptor.isSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#isFixedPitch()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isFixedPitch()}
   */
  @Test
  @DisplayName("Test isFixedPitch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isFixedPitch()"})
  void testIsFixedPitch() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isFixedPitch());
  }

  /**
   * Test {@link PDFontDescriptor#setFixedPitch(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFixedPitch(boolean)}
   */
  @Test
  @DisplayName("Test setFixedPitch(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFixedPitch(boolean)"})
  void testSetFixedPitch_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFixedPitch(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Test {@link PDFontDescriptor#setFixedPitch(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFixedPitch(boolean)}
   */
  @Test
  @DisplayName("Test setFixedPitch(boolean); when 'true'; then PDFontDescriptor() Flags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFixedPitch(boolean)"})
  void testSetFixedPitch_whenTrue_thenPDFontDescriptorFlagsIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFixedPitch(true);

    // Assert
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Test {@link PDFontDescriptor#isSerif()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isSerif()}
   */
  @Test
  @DisplayName("Test isSerif()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isSerif()"})
  void testIsSerif() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isSerif());
  }

  /**
   * Test {@link PDFontDescriptor#setSerif(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSerif(boolean)}
   */
  @Test
  @DisplayName("Test setSerif(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSerif(boolean)"})
  void testSetSerif_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSerif(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSerif());
  }

  /**
   * Test {@link PDFontDescriptor#setSerif(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is two.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSerif(boolean)}
   */
  @Test
  @DisplayName("Test setSerif(boolean); when 'true'; then PDFontDescriptor() Flags is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSerif(boolean)"})
  void testSetSerif_whenTrue_thenPDFontDescriptorFlagsIsTwo() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSerif(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isSerif());
  }

  /**
   * Test {@link PDFontDescriptor#isSymbolic()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isSymbolic()}
   */
  @Test
  @DisplayName("Test isSymbolic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isSymbolic()"})
  void testIsSymbolic() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#setSymbolic(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSymbolic(boolean)}
   */
  @Test
  @DisplayName("Test setSymbolic(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSymbolic(boolean)"})
  void testSetSymbolic_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSymbolic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#setSymbolic(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is four.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSymbolic(boolean)}
   */
  @Test
  @DisplayName("Test setSymbolic(boolean); when 'true'; then PDFontDescriptor() Flags is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSymbolic(boolean)"})
  void testSetSymbolic_whenTrue_thenPDFontDescriptorFlagsIsFour() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSymbolic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(4, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#isScript()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isScript()}
   */
  @Test
  @DisplayName("Test isScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isScript()"})
  void testIsScript() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isScript());
  }

  /**
   * Test {@link PDFontDescriptor#setScript(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setScript(boolean)}
   */
  @Test
  @DisplayName("Test setScript(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setScript(boolean)"})
  void testSetScript_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setScript(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isScript());
  }

  /**
   * Test {@link PDFontDescriptor#setScript(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is eight.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setScript(boolean)}
   */
  @Test
  @DisplayName("Test setScript(boolean); when 'true'; then PDFontDescriptor() Flags is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setScript(boolean)"})
  void testSetScript_whenTrue_thenPDFontDescriptorFlagsIsEight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setScript(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isScript());
  }

  /**
   * Test {@link PDFontDescriptor#isNonSymbolic()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isNonSymbolic()}
   */
  @Test
  @DisplayName("Test isNonSymbolic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isNonSymbolic()"})
  void testIsNonSymbolic() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isNonSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#setNonSymbolic(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setNonSymbolic(boolean)}
   */
  @Test
  @DisplayName("Test setNonSymbolic(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setNonSymbolic(boolean)"})
  void testSetNonSymbolic_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setNonSymbolic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isNonSymbolic());
  }

  /**
   * Test {@link PDFontDescriptor#setNonSymbolic(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} NonSymbolic.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setNonSymbolic(boolean)}
   */
  @Test
  @DisplayName("Test setNonSymbolic(boolean); when 'true'; then PDFontDescriptor() NonSymbolic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setNonSymbolic(boolean)"})
  void testSetNonSymbolic_whenTrue_thenPDFontDescriptorNonSymbolic() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setNonSymbolic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isNonSymbolic());
    assertEquals(Integer.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Test {@link PDFontDescriptor#isItalic()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isItalic()}
   */
  @Test
  @DisplayName("Test isItalic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isItalic()"})
  void testIsItalic() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isItalic());
  }

  /**
   * Test {@link PDFontDescriptor#setItalic(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setItalic(boolean)}
   */
  @Test
  @DisplayName("Test setItalic(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setItalic(boolean)"})
  void testSetItalic_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isItalic());
  }

  /**
   * Test {@link PDFontDescriptor#setItalic(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Italic.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setItalic(boolean)}
   */
  @Test
  @DisplayName("Test setItalic(boolean); when 'true'; then PDFontDescriptor() Italic")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setItalic(boolean)"})
  void testSetItalic_whenTrue_thenPDFontDescriptorItalic() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isItalic());
    assertEquals(Double.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Test {@link PDFontDescriptor#isAllCap()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isAllCap()}
   */
  @Test
  @DisplayName("Test isAllCap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isAllCap()"})
  void testIsAllCap() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isAllCap());
  }

  /**
   * Test {@link PDFontDescriptor#setAllCap(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setAllCap(boolean)}
   */
  @Test
  @DisplayName("Test setAllCap(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setAllCap(boolean)"})
  void testSetAllCap_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAllCap(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
  }

  /**
   * Test {@link PDFontDescriptor#setAllCap(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is {@code 65536}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setAllCap(boolean)}
   */
  @Test
  @DisplayName("Test setAllCap(boolean); when 'true'; then PDFontDescriptor() Flags is '65536'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setAllCap(boolean)"})
  void testSetAllCap_whenTrue_thenPDFontDescriptorFlagsIs65536() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAllCap(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(65536, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isAllCap());
  }

  /**
   * Test {@link PDFontDescriptor#isSmallCap()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isSmallCap()}
   */
  @Test
  @DisplayName("Test isSmallCap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isSmallCap()"})
  void testIsSmallCap() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isSmallCap());
  }

  /**
   * Test {@link PDFontDescriptor#setSmallCap(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSmallCap(boolean)}
   */
  @Test
  @DisplayName("Test setSmallCap(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSmallCap(boolean)"})
  void testSetSmallCap_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSmallCap(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSmallCap());
  }

  /**
   * Test {@link PDFontDescriptor#setSmallCap(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is {@code 131072}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setSmallCap(boolean)}
   */
  @Test
  @DisplayName("Test setSmallCap(boolean); when 'true'; then PDFontDescriptor() Flags is '131072'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setSmallCap(boolean)"})
  void testSetSmallCap_whenTrue_thenPDFontDescriptorFlagsIs131072() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSmallCap(true);

    // Assert
    assertEquals(131072, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isSmallCap());
  }

  /**
   * Test {@link PDFontDescriptor#isForceBold()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#isForceBold()}
   */
  @Test
  @DisplayName("Test isForceBold()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.isForceBold()"})
  void testIsForceBold() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().isForceBold());
  }

  /**
   * Test {@link PDFontDescriptor#setForceBold(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setForceBold(boolean)}
   */
  @Test
  @DisplayName("Test setForceBold(boolean); when 'false'; then PDFontDescriptor() Flags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setForceBold(boolean)"})
  void testSetForceBold_whenFalse_thenPDFontDescriptorFlagsIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setForceBold(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isForceBold());
  }

  /**
   * Test {@link PDFontDescriptor#setForceBold(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is {@code 262144}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setForceBold(boolean)}
   */
  @Test
  @DisplayName("Test setForceBold(boolean); when 'true'; then PDFontDescriptor() Flags is '262144'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setForceBold(boolean)"})
  void testSetForceBold_whenTrue_thenPDFontDescriptorFlagsIs262144() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setForceBold(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(262144, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isForceBold());
  }

  /**
   * Test {@link PDFontDescriptor#getCOSObject()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDFontDescriptor.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDFontDescriptor().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFontDescriptor#getFontName()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code Font Name}.
   *   <li>Then return {@code Font Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontName()}
   */
  @Test
  @DisplayName(
      "Test getFontName(); given PDFontDescriptor() FontName is 'Font Name'; then return 'Font Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontName()"})
  void testGetFontName_givenPDFontDescriptorFontNameIsFontName_thenReturnFontName() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontName("Font Name");

    // Act and Assert
    assertEquals("Font Name", pdFontDescriptor.getFontName());
  }

  /**
   * Test {@link PDFontDescriptor#getFontName()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontName()}
   */
  @Test
  @DisplayName("Test getFontName(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontName()"})
  void testGetFontName_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontName());
  }

  /**
   * Test {@link PDFontDescriptor#setFontName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  @DisplayName("Test setFontName(String); when '42'; then PDFontDescriptor() FontName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontName(String)"})
  void testSetFontName_when42_thenPDFontDescriptorFontNameIs42() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName("42");

    // Assert
    assertEquals("42", pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontName(String)}.
   *
   * <ul>
   *   <li>When {@code Font Name}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code Font Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  @DisplayName(
      "Test setFontName(String); when 'Font Name'; then PDFontDescriptor() FontName is 'Font Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontName(String)"})
  void testSetFontName_whenFontName_thenPDFontDescriptorFontNameIsFontName() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName("Font Name");

    // Assert
    assertEquals("Font Name", pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  @DisplayName(
      "Test setFontName(String); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontName(String)"})
  void testSetFontName_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFamily()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  @DisplayName("Test getFontFamily(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontFamily()"})
  void testGetFontFamily_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontFamily());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFamily()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  @DisplayName("Test getFontFamily(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontFamily()"})
  void testGetFontFamily_thenReturnEmptyString() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFamily("");

    // Act and Assert
    assertEquals("", pdFontDescriptor.getFontFamily());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFamily()}.
   *
   * <ul>
   *   <li>Then return {@code Font Family}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  @DisplayName("Test getFontFamily(); then return 'Font Family'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontFamily()"})
  void testGetFontFamily_thenReturnFontFamily() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFamily("Font Family");

    // Act and Assert
    assertEquals("Font Family", pdFontDescriptor.getFontFamily());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFamily(String)}.
   *
   * <ul>
   *   <li>When {@code Font Family}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontFamily is {@code Font Family}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFamily(String)}
   */
  @Test
  @DisplayName(
      "Test setFontFamily(String); when 'Font Family'; then PDFontDescriptor() FontFamily is 'Font Family'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFamily(String)"})
  void testSetFontFamily_whenFontFamily_thenPDFontDescriptorFontFamilyIsFontFamily() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFamily("Font Family");

    // Assert
    assertEquals("Font Family", pdFontDescriptor.getFontFamily());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFamily(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFamily(String)}
   */
  @Test
  @DisplayName(
      "Test setFontFamily(String); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFamily(String)"})
  void testSetFontFamily_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFamily(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontWeight()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontWeight is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontWeight()}
   */
  @Test
  @DisplayName("Test getFontWeight(); given PDFontDescriptor() FontWeight is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getFontWeight()"})
  void testGetFontWeight_givenPDFontDescriptorFontWeightIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontWeight(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getFontWeight());
  }

  /**
   * Test {@link PDFontDescriptor#getFontWeight()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontWeight()}
   */
  @Test
  @DisplayName("Test getFontWeight(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getFontWeight()"})
  void testGetFontWeight_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getFontWeight());
  }

  /**
   * Test {@link PDFontDescriptor#setFontWeight(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontWeight(float)}
   */
  @Test
  @DisplayName("Test setFontWeight(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontWeight(float)"})
  void testSetFontWeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontWeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getFontWeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontStretch()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontStretch()}
   */
  @Test
  @DisplayName("Test getFontStretch(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontStretch()"})
  void testGetFontStretch_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontStretch());
  }

  /**
   * Test {@link PDFontDescriptor#getFontStretch()}.
   *
   * <ul>
   *   <li>Then return {@code Font Stretch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontStretch()}
   */
  @Test
  @DisplayName("Test getFontStretch(); then return 'Font Stretch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getFontStretch()"})
  void testGetFontStretch_thenReturnFontStretch() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontStretch("Font Stretch");

    // Act and Assert
    assertEquals("Font Stretch", pdFontDescriptor.getFontStretch());
  }

  /**
   * Test {@link PDFontDescriptor#setFontStretch(String)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontStretch is {@code Font StretchFont
   *       Stretch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  @DisplayName(
      "Test setFontStretch(String); then PDFontDescriptor() FontStretch is 'Font StretchFont Stretch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontStretch(String)"})
  void testSetFontStretch_thenPDFontDescriptorFontStretchIsFontStretchFontStretch() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch("Font StretchFont Stretch");

    // Assert
    assertEquals("Font StretchFont Stretch", pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontStretch(String)}.
   *
   * <ul>
   *   <li>When {@code Font Stretch}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontStretch is {@code Font Stretch}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  @DisplayName(
      "Test setFontStretch(String); when 'Font Stretch'; then PDFontDescriptor() FontStretch is 'Font Stretch'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontStretch(String)"})
  void testSetFontStretch_whenFontStretch_thenPDFontDescriptorFontStretchIsFontStretch() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch("Font Stretch");

    // Assert
    assertEquals("Font Stretch", pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontStretch(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  @DisplayName(
      "Test setFontStretch(String); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontStretch(String)"})
  void testSetFontStretch_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFlags()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#getFlags()}
   */
  @Test
  @DisplayName("Test getFlags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFontDescriptor.getFlags()"})
  void testGetFlags() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFontDescriptor().getFlags());
  }

  /**
   * Test {@link PDFontDescriptor#setFlags(int)}.
   *
   * <ul>
   *   <li>When {@code 65536}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is {@code 65536}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); when '65536'; then PDFontDescriptor() Flags is '65536'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFlags(int)"})
  void testSetFlags_when65536_thenPDFontDescriptorFlagsIs65536() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(65536);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(65536, pdFontDescriptor.getFlags());
    assertFalse(pdFontDescriptor.isFixedPitch());
    assertTrue(pdFontDescriptor.isAllCap());
  }

  /**
   * Test {@link PDFontDescriptor#setFlags(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); when MIN_VALUE; then PDFontDescriptor() Flags is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFlags(int)"})
  void testSetFlags_whenMin_value_thenPDFontDescriptorFlagsIsMin_value() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
    assertFalse(pdFontDescriptor.isFixedPitch());
    assertEquals(Integer.MIN_VALUE, pdFontDescriptor.getFlags());
  }

  /**
   * Test {@link PDFontDescriptor#setFlags(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} Flags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  @DisplayName("Test setFlags(int); when one; then PDFontDescriptor() Flags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFlags(int)"})
  void testSetFlags_whenOne_thenPDFontDescriptorFlagsIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(1);

    // Assert
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Test {@link PDFontDescriptor#getFontBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  @DisplayName("Test getFontBoundingBox(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFontDescriptor.getFontBoundingBox()"})
  void testGetFontBoundingBox_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontBoundingBox());
  }

  /**
   * Test {@link PDFontDescriptor#getFontBoundingBox()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  @DisplayName("Test getFontBoundingBox(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFontDescriptor.getFontBoundingBox()"})
  void testGetFontBoundingBox_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontBoundingBox(PDRectangle.A0);

    // Act
    PDRectangle actualFontBoundingBox = pdFontDescriptor.getFontBoundingBox();

    // Assert
    List<? extends COSBase> toListResult = actualFontBoundingBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualFontBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualFontBoundingBox.getLowerLeftY());
    assertEquals(2383.937f, actualFontBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualFontBoundingBox.getWidth());
    assertEquals(3370.3938f, actualFontBoundingBox.getHeight());
    assertEquals(3370.3938f, actualFontBoundingBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDFontDescriptor#getFontBoundingBox()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  @DisplayName("Test getFontBoundingBox(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDFontDescriptor.getFontBoundingBox()"})
  void testGetFontBoundingBox_thenReturnHeightIsZero() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdFontDescriptor.setFontBoundingBox(rect);

    // Act
    PDRectangle actualFontBoundingBox = pdFontDescriptor.getFontBoundingBox();

    // Assert
    List<? extends COSBase> toListResult = actualFontBoundingBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFontBoundingBox.getHeight());
    assertEquals(0.0f, actualFontBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject toIncrement Objects Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFontBoundingBox(PDRectangle); then PDFontDescriptor() COSObject toIncrement Objects Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontBoundingBox(PDRectangle)"})
  void testSetFontBoundingBox_thenPDFontDescriptorCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontBoundingBox(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = pdFontDescriptor.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox UpperRightX is {@code
   *       1683.7795}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFontBoundingBox(PDRectangle); then PDFontDescriptor() FontBoundingBox UpperRightX is '1683.7795'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontBoundingBox(PDRectangle)"})
  void testSetFontBoundingBox_thenPDFontDescriptorFontBoundingBoxUpperRightXIs16837795() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontBoundingBox(PDRectangle.A1);

    // Assert
    PDRectangle fontBoundingBox = pdFontDescriptor.getFontBoundingBox();
    assertEquals(1683.7795f, fontBoundingBox.getUpperRightX());
    assertEquals(1683.7795f, fontBoundingBox.getWidth());
    assertEquals(2383.937f, fontBoundingBox.getHeight());
    assertEquals(2383.937f, fontBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDFontDescriptor#getItalicAngle()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} ItalicAngle is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getItalicAngle()}
   */
  @Test
  @DisplayName(
      "Test getItalicAngle(); given PDFontDescriptor() ItalicAngle is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getItalicAngle()"})
  void testGetItalicAngle_givenPDFontDescriptorItalicAngleIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setItalicAngle(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getItalicAngle());
  }

  /**
   * Test {@link PDFontDescriptor#getItalicAngle()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getItalicAngle()}
   */
  @Test
  @DisplayName("Test getItalicAngle(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getItalicAngle()"})
  void testGetItalicAngle_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getItalicAngle());
  }

  /**
   * Test {@link PDFontDescriptor#setItalicAngle(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setItalicAngle(float)}
   */
  @Test
  @DisplayName("Test setItalicAngle(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setItalicAngle(float)"})
  void testSetItalicAngle() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalicAngle(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getItalicAngle());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getAscent()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} Ascent is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getAscent()}
   */
  @Test
  @DisplayName("Test getAscent(); given PDFontDescriptor() Ascent is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getAscent()"})
  void testGetAscent_givenPDFontDescriptorAscentIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setAscent(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getAscent());
  }

  /**
   * Test {@link PDFontDescriptor#getAscent()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getAscent()}
   */
  @Test
  @DisplayName("Test getAscent(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getAscent()"})
  void testGetAscent_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getAscent());
  }

  /**
   * Test {@link PDFontDescriptor#setAscent(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setAscent(float)}
   */
  @Test
  @DisplayName("Test setAscent(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setAscent(float)"})
  void testSetAscent() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAscent(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getAscent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getDescent()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} Descent is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getDescent()}
   */
  @Test
  @DisplayName("Test getDescent(); given PDFontDescriptor() Descent is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getDescent()"})
  void testGetDescent_givenPDFontDescriptorDescentIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setDescent(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getDescent());
  }

  /**
   * Test {@link PDFontDescriptor#getDescent()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getDescent()}
   */
  @Test
  @DisplayName("Test getDescent(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getDescent()"})
  void testGetDescent_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getDescent());
  }

  /**
   * Test {@link PDFontDescriptor#setDescent(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setDescent(float)}
   */
  @Test
  @DisplayName("Test setDescent(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setDescent(float)"})
  void testSetDescent() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setDescent(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getDescent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getLeading()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} Leading is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getLeading()}
   */
  @Test
  @DisplayName("Test getLeading(); given PDFontDescriptor() Leading is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getLeading()"})
  void testGetLeading_givenPDFontDescriptorLeadingIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setLeading(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getLeading());
  }

  /**
   * Test {@link PDFontDescriptor#getLeading()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getLeading()}
   */
  @Test
  @DisplayName("Test getLeading(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getLeading()"})
  void testGetLeading_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getLeading());
  }

  /**
   * Test {@link PDFontDescriptor#setLeading(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setLeading(float)}
   */
  @Test
  @DisplayName("Test setLeading(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setLeading(float)"})
  void testSetLeading() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setLeading(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getLeading());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getCapHeight()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#getCapHeight()}
   */
  @Test
  @DisplayName("Test getCapHeight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getCapHeight()"})
  void testGetCapHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getCapHeight());
  }

  /**
   * Test {@link PDFontDescriptor#setCapHeight(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setCapHeight(float)}
   */
  @Test
  @DisplayName("Test setCapHeight(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setCapHeight(float)"})
  void testSetCapHeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCapHeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getCapHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getXHeight()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#getXHeight()}
   */
  @Test
  @DisplayName("Test getXHeight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getXHeight()"})
  void testGetXHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getXHeight());
  }

  /**
   * Test {@link PDFontDescriptor#setXHeight(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setXHeight(float)}
   */
  @Test
  @DisplayName("Test setXHeight(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setXHeight(float)"})
  void testSetXHeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setXHeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getXHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getStemV()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} StemV is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getStemV()}
   */
  @Test
  @DisplayName("Test getStemV(); given PDFontDescriptor() StemV is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getStemV()"})
  void testGetStemV_givenPDFontDescriptorStemVIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setStemV(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getStemV());
  }

  /**
   * Test {@link PDFontDescriptor#getStemV()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getStemV()}
   */
  @Test
  @DisplayName("Test getStemV(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getStemV()"})
  void testGetStemV_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getStemV());
  }

  /**
   * Test {@link PDFontDescriptor#setStemV(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setStemV(float)}
   */
  @Test
  @DisplayName("Test setStemV(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setStemV(float)"})
  void testSetStemV() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setStemV(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getStemV());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getStemH()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} StemH is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getStemH()}
   */
  @Test
  @DisplayName("Test getStemH(); given PDFontDescriptor() StemH is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getStemH()"})
  void testGetStemH_givenPDFontDescriptorStemHIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setStemH(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getStemH());
  }

  /**
   * Test {@link PDFontDescriptor#getStemH()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getStemH()}
   */
  @Test
  @DisplayName("Test getStemH(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getStemH()"})
  void testGetStemH_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getStemH());
  }

  /**
   * Test {@link PDFontDescriptor#setStemH(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setStemH(float)}
   */
  @Test
  @DisplayName("Test setStemH(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setStemH(float)"})
  void testSetStemH() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setStemH(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getStemH());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getAverageWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} AverageWidth is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getAverageWidth()}
   */
  @Test
  @DisplayName(
      "Test getAverageWidth(); given PDFontDescriptor() AverageWidth is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getAverageWidth()"})
  void testGetAverageWidth_givenPDFontDescriptorAverageWidthIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setAverageWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getAverageWidth());
  }

  /**
   * Test {@link PDFontDescriptor#getAverageWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getAverageWidth()}
   */
  @Test
  @DisplayName("Test getAverageWidth(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getAverageWidth()"})
  void testGetAverageWidth_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getAverageWidth());
  }

  /**
   * Test {@link PDFontDescriptor#setAverageWidth(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setAverageWidth(float)}
   */
  @Test
  @DisplayName("Test setAverageWidth(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setAverageWidth(float)"})
  void testSetAverageWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAverageWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getAverageWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getMaxWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MaxWidth is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getMaxWidth()}
   */
  @Test
  @DisplayName("Test getMaxWidth(); given PDFontDescriptor() MaxWidth is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getMaxWidth()"})
  void testGetMaxWidth_givenPDFontDescriptorMaxWidthIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMaxWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getMaxWidth());
  }

  /**
   * Test {@link PDFontDescriptor#getMaxWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getMaxWidth()}
   */
  @Test
  @DisplayName("Test getMaxWidth(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getMaxWidth()"})
  void testGetMaxWidth_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getMaxWidth());
  }

  /**
   * Test {@link PDFontDescriptor#setMaxWidth(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setMaxWidth(float)}
   */
  @Test
  @DisplayName("Test setMaxWidth(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setMaxWidth(float)"})
  void testSetMaxWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setMaxWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getMaxWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#hasWidths()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MissingWidth is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#hasWidths()}
   */
  @Test
  @DisplayName("Test hasWidths(); given PDFontDescriptor() MissingWidth is ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.hasWidths()"})
  void testHasWidths_givenPDFontDescriptorMissingWidthIsTen_thenReturnTrue() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertTrue(pdFontDescriptor.hasWidths());
  }

  /**
   * Test {@link PDFontDescriptor#hasWidths()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#hasWidths()}
   */
  @Test
  @DisplayName("Test hasWidths(); given PDFontDescriptor(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.hasWidths()"})
  void testHasWidths_givenPDFontDescriptor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().hasWidths());
  }

  /**
   * Test {@link PDFontDescriptor#hasMissingWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MissingWidth is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#hasMissingWidth()}
   */
  @Test
  @DisplayName(
      "Test hasMissingWidth(); given PDFontDescriptor() MissingWidth is ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.hasMissingWidth()"})
  void testHasMissingWidth_givenPDFontDescriptorMissingWidthIsTen_thenReturnTrue() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertTrue(pdFontDescriptor.hasMissingWidth());
  }

  /**
   * Test {@link PDFontDescriptor#hasMissingWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#hasMissingWidth()}
   */
  @Test
  @DisplayName("Test hasMissingWidth(); given PDFontDescriptor(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFontDescriptor.hasMissingWidth()"})
  void testHasMissingWidth_givenPDFontDescriptor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDFontDescriptor().hasMissingWidth());
  }

  /**
   * Test {@link PDFontDescriptor#getMissingWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MissingWidth is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getMissingWidth()}
   */
  @Test
  @DisplayName(
      "Test getMissingWidth(); given PDFontDescriptor() MissingWidth is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getMissingWidth()"})
  void testGetMissingWidth_givenPDFontDescriptorMissingWidthIsTen_thenReturnTen() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getMissingWidth());
  }

  /**
   * Test {@link PDFontDescriptor#getMissingWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getMissingWidth()}
   */
  @Test
  @DisplayName("Test getMissingWidth(); given PDFontDescriptor(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDFontDescriptor.getMissingWidth()"})
  void testGetMissingWidth_givenPDFontDescriptor_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDFontDescriptor().getMissingWidth());
  }

  /**
   * Test {@link PDFontDescriptor#setMissingWidth(float)}.
   *
   * <p>Method under test: {@link PDFontDescriptor#setMissingWidth(float)}
   */
  @Test
  @DisplayName("Test setMissingWidth(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setMissingWidth(float)"})
  void testSetMissingWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setMissingWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getMissingWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getCharSet()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} CharacterSet is {@code Char Set}.
   *   <li>Then return {@code Char Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  @DisplayName(
      "Test getCharSet(); given PDFontDescriptor() CharacterSet is 'Char Set'; then return 'Char Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getCharSet()"})
  void testGetCharSet_givenPDFontDescriptorCharacterSetIsCharSet_thenReturnCharSet() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCharacterSet("Char Set");

    // Act and Assert
    assertEquals("Char Set", pdFontDescriptor.getCharSet());
  }

  /**
   * Test {@link PDFontDescriptor#getCharSet()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  @DisplayName("Test getCharSet(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getCharSet()"})
  void testGetCharSet_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getCharSet());
  }

  /**
   * Test {@link PDFontDescriptor#getCharSet()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  @DisplayName("Test getCharSet(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDFontDescriptor.getCharSet()"})
  void testGetCharSet_thenReturnEmptyString() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCharacterSet("");

    // Act and Assert
    assertEquals("", pdFontDescriptor.getCharSet());
  }

  /**
   * Test {@link PDFontDescriptor#setCharacterSet(String)}.
   *
   * <ul>
   *   <li>When {@code Char Set}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} CharSet is {@code Char Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setCharacterSet(String)}
   */
  @Test
  @DisplayName(
      "Test setCharacterSet(String); when 'Char Set'; then PDFontDescriptor() CharSet is 'Char Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setCharacterSet(String)"})
  void testSetCharacterSet_whenCharSet_thenPDFontDescriptorCharSetIsCharSet() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCharacterSet("Char Set");

    // Assert
    assertEquals("Char Set", pdFontDescriptor.getCharSet());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setCharacterSet(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setCharacterSet(String)}
   */
  @Test
  @DisplayName(
      "Test setCharacterSet(String); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setCharacterSet(String)"})
  void testSetCharacterSet_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCharacterSet(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile()}
   */
  @Test
  @DisplayName("Test getFontFile(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile()"})
  void testGetFontFile_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontFile());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile()}.
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile()}
   */
  @Test
  @DisplayName("Test getFontFile(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile()"})
  void testGetFontFile_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile = pdFontDescriptor.getFontFile();

    // Assert
    assertNull(actualFontFile.getDecodeParms());
    assertNull(actualFontFile.getFileDecodeParams());
    assertNull(actualFontFile.getMetadata());
    assertNull(actualFontFile.getFile());
    assertEquals(-1, actualFontFile.getDecodedStreamLength());
    assertEquals(0, actualFontFile.getLength());
    List<String> fileFilters = actualFontFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualFontFile.getFilters());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile(PDStream)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontFile DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile(PDStream)}
   */
  @Test
  @DisplayName("Test setFontFile(PDStream); then PDFontDescriptor() FontFile DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile(PDStream)"})
  void testSetFontFile_thenPDFontDescriptorFontFileDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile = pdFontDescriptor.getFontFile();
    assertNull(fontFile.getDecodeParms());
    assertNull(fontFile.getFileDecodeParams());
    assertNull(fontFile.getMetadata());
    assertNull(fontFile.getFile());
    assertEquals(-1, fontFile.getDecodedStreamLength());
    assertEquals(0, fontFile.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile(PDStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setFontFile(PDStream); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile(PDStream)"})
  void testSetFontFile_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile2()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile2()}
   */
  @Test
  @DisplayName("Test getFontFile2(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile2()"})
  void testGetFontFile2_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontFile2());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile2()}.
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile2()}
   */
  @Test
  @DisplayName("Test getFontFile2(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile2()"})
  void testGetFontFile2_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile2(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile2 = pdFontDescriptor.getFontFile2();

    // Assert
    assertNull(actualFontFile2.getDecodeParms());
    assertNull(actualFontFile2.getFileDecodeParams());
    assertNull(actualFontFile2.getMetadata());
    assertNull(actualFontFile2.getFile());
    assertEquals(-1, actualFontFile2.getDecodedStreamLength());
    assertEquals(0, actualFontFile2.getLength());
    List<String> fileFilters = actualFontFile2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualFontFile2.getFilters());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile2(PDStream)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontFile2 DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile2(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setFontFile2(PDStream); then PDFontDescriptor() FontFile2 DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile2(PDStream)"})
  void testSetFontFile2_thenPDFontDescriptorFontFile2DecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile2(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile2 = pdFontDescriptor.getFontFile2();
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(fontFile2.getMetadata());
    assertNull(fontFile2.getFile());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    assertEquals(0, fontFile2.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile2(PDStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile2(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setFontFile2(PDStream); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile2(PDStream)"})
  void testSetFontFile2_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile2(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile3()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile3()}
   */
  @Test
  @DisplayName("Test getFontFile3(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile3()"})
  void testGetFontFile3_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getFontFile3());
  }

  /**
   * Test {@link PDFontDescriptor#getFontFile3()}.
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getFontFile3()}
   */
  @Test
  @DisplayName("Test getFontFile3(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getFontFile3()"})
  void testGetFontFile3_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile3(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile3 = pdFontDescriptor.getFontFile3();

    // Assert
    assertNull(actualFontFile3.getDecodeParms());
    assertNull(actualFontFile3.getFileDecodeParams());
    assertNull(actualFontFile3.getMetadata());
    assertNull(actualFontFile3.getFile());
    assertEquals(-1, actualFontFile3.getDecodedStreamLength());
    assertEquals(0, actualFontFile3.getLength());
    List<String> fileFilters = actualFontFile3.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualFontFile3.getFilters());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile3(PDStream)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} FontFile3 DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile3(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setFontFile3(PDStream); then PDFontDescriptor() FontFile3 DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile3(PDStream)"})
  void testSetFontFile3_thenPDFontDescriptorFontFile3DecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile3(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile3 = pdFontDescriptor.getFontFile3();
    assertNull(fontFile3.getDecodeParms());
    assertNull(fontFile3.getFileDecodeParams());
    assertNull(fontFile3.getMetadata());
    assertNull(fontFile3.getFile());
    assertEquals(-1, fontFile3.getDecodedStreamLength());
    assertEquals(0, fontFile3.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setFontFile3(PDStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setFontFile3(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setFontFile3(PDStream); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setFontFile3(PDStream)"})
  void testSetFontFile3_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile3(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getCIDSet()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getCIDSet()}
   */
  @Test
  @DisplayName("Test getCIDSet(); given PDFontDescriptor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getCIDSet()"})
  void testGetCIDSet_givenPDFontDescriptor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getCIDSet());
  }

  /**
   * Test {@link PDFontDescriptor#getCIDSet()}.
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#getCIDSet()}
   */
  @Test
  @DisplayName("Test getCIDSet(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDFontDescriptor.getCIDSet()"})
  void testGetCIDSet_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCIDSet(new PDStream(new COSDocument()));

    // Act
    PDStream actualCIDSet = pdFontDescriptor.getCIDSet();

    // Assert
    assertNull(actualCIDSet.getDecodeParms());
    assertNull(actualCIDSet.getFileDecodeParams());
    assertNull(actualCIDSet.getMetadata());
    assertNull(actualCIDSet.getFile());
    assertEquals(-1, actualCIDSet.getDecodedStreamLength());
    assertEquals(0, actualCIDSet.getLength());
    List<String> fileFilters = actualCIDSet.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualCIDSet.getFilters());
  }

  /**
   * Test {@link PDFontDescriptor#setCIDSet(PDStream)}.
   *
   * <ul>
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} CIDSet DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setCIDSet(PDStream)}
   */
  @Test
  @DisplayName("Test setCIDSet(PDStream); then PDFontDescriptor() CIDSet DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setCIDSet(PDStream)"})
  void testSetCIDSet_thenPDFontDescriptorCIDSetDecodeParmsIsNull() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCIDSet(new PDStream(new COSDocument()));

    // Assert
    PDStream cIDSet = pdFontDescriptor.getCIDSet();
    assertNull(cIDSet.getDecodeParms());
    assertNull(cIDSet.getFileDecodeParams());
    assertNull(cIDSet.getMetadata());
    assertNull(cIDSet.getFile());
    assertEquals(-1, cIDSet.getDecodedStreamLength());
    assertEquals(0, cIDSet.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#setCIDSet(PDStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDFontDescriptor#PDFontDescriptor()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDFontDescriptor#setCIDSet(PDStream)}
   */
  @Test
  @DisplayName(
      "Test setCIDSet(PDStream); when 'null'; then PDFontDescriptor() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFontDescriptor.setCIDSet(PDStream)"})
  void testSetCIDSet_whenNull_thenPDFontDescriptorCOSObjectValuesSizeIsOne() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCIDSet(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDFontDescriptor#getPanose()}.
   *
   * <p>Method under test: {@link PDFontDescriptor#getPanose()}
   */
  @Test
  @DisplayName("Test getPanose()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDPanose PDFontDescriptor.getPanose()"})
  void testGetPanose() {
    // Arrange, Act and Assert
    assertNull(new PDFontDescriptor().getPanose());
  }
}
