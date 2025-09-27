package org.apache.pdfbox.pdmodel.graphics.state;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.List;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDFontSetting;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendComposite;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDExtendedGraphicsStateDiffblueTest {
  /**
   * Test {@link PDExtendedGraphicsState#PDExtendedGraphicsState(COSDictionary)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#PDExtendedGraphicsState(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDExtendedGraphicsState(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.<init>(COSDictionary)"})
  void testNewPDExtendedGraphicsState() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDExtendedGraphicsState(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}
   */
  @Test
  @DisplayName("Test new PDExtendedGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.<init>()"})
  void testNewPDExtendedGraphicsState2() {
    // Arrange and Act
    PDExtendedGraphicsState actualPdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Assert
    assertNull(actualPdExtendedGraphicsState.getFlatnessTolerance());
    assertNull(actualPdExtendedGraphicsState.getLineWidth());
    assertNull(actualPdExtendedGraphicsState.getMiterLimit());
    assertNull(actualPdExtendedGraphicsState.getNonStrokingAlphaConstant());
    assertNull(actualPdExtendedGraphicsState.getSmoothnessTolerance());
    assertNull(actualPdExtendedGraphicsState.getStrokingAlphaConstant());
    assertNull(actualPdExtendedGraphicsState.getOverprintMode());
    assertNull(actualPdExtendedGraphicsState.getTransfer());
    assertNull(actualPdExtendedGraphicsState.getTransfer2());
    assertNull(actualPdExtendedGraphicsState.getFontSetting());
    assertNull(actualPdExtendedGraphicsState.getLineDashPattern());
    assertNull(actualPdExtendedGraphicsState.getSoftMask());
    assertNull(actualPdExtendedGraphicsState.getRenderingIntent());
    assertEquals(-1, actualPdExtendedGraphicsState.getLineCapStyle());
    assertEquals(-1, actualPdExtendedGraphicsState.getLineJoinStyle());
    assertFalse(actualPdExtendedGraphicsState.getAlphaSourceFlag());
    assertFalse(actualPdExtendedGraphicsState.getAutomaticStrokeAdjustment());
    assertFalse(actualPdExtendedGraphicsState.getNonStrokingOverprintControl());
    assertFalse(actualPdExtendedGraphicsState.getStrokingOverprintControl());
    assertTrue(actualPdExtendedGraphicsState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineDashPattern(new PDLineDashPattern());
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState2() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setRenderingIntent("Type");
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(RenderingIntent.RELATIVE_COLORIMETRIC, gs.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState3() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setBlendMode(BlendMode.COLOR);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    Rectangle2D frame = gs.getCurrentClippingPath().getBounds().getBounds().getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D frame2 = frame.getFrame();
    assertTrue(frame2 instanceof Double);
    assertTrue(gs.getNonStrokingJavaComposite() instanceof BlendComposite);
    assertTrue(gs.getStrokingJavaComposite() instanceof BlendComposite);
    BlendMode blendMode = gs.getBlendMode();
    assertEquals("Color", blendMode.getCOSName().getName());
    assertNull(blendMode.getBlendChannelFunction());
    assertEquals(2384.0d, frame2.getMaxX());
    assertEquals(3371.0d, frame2.getMaxY());
    assertFalse(blendMode.isSeparableBlendMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState4() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(false);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState5() throws IOException {
    // Arrange
    PDFontSetting fs = new PDFontSetting();
    fs.setFont(new PDMMType1Font(new COSDictionary()));

    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setFontSetting(fs);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    PDFont font = gs.getTextState().getFont();
    FontBoxFont fontBoxFont = ((PDType1Font) font).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(font instanceof PDType1Font);
    assertNull(font.getCOSObject().getKey());
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) fontBoxFont).getOS2Windows();
    assertEquals(0, oS2Windows.getDefaultChar());
    assertEquals(1610612895L, oS2Windows.getCodePageRange1());
    float[][] values = font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3755409408L, oS2Windows.getCodePageRange2());
    assertEquals(4193550753L, oS2Windows.getCheckSum());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState6() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    fontDictionary.setKey(key);
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    PDFontSetting fs = new PDFontSetting();
    fs.setFont(font);

    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setFontSetting(fs);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    PDFont font2 = gs.getTextState().getFont();
    assertTrue(font2 instanceof PDType1Font);
    float[][] values = font2.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, font2.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName("Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsState() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} RenderingIntent is {@code
   *       LW}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() RenderingIntent is 'LW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateRenderingIntentIsLw()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setRenderingIntent("LW");
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(RenderingIntent.RELATIVE_COLORIMETRIC, gs.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} TextKnockoutFlag is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() TextKnockoutFlag is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateTextKnockoutFlagIsTrue()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTextKnockoutFlag(true);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer2 is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() Transfer2 is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateTransfer2IsCOSArray()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer2(new COSArray());
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() Transfer is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateTransferIsCOSArray()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer(new COSArray());
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert that nothing has changed
    assertEquals(0.0f, gs.getTextState().getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() Transfer is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateTransferIsCOSArray2()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer2(COSBoolean.FALSE);
    pdExtendedGraphicsState.setTransfer(new COSArray());
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    COSBase transfer = gs.getTransfer();
    assertTrue(transfer instanceof COSBoolean);
    assertNull(transfer.getKey());
    assertFalse(transfer.isDirect());
    assertFalse(((COSBoolean) transfer).getValue());
    assertFalse(((COSBoolean) transfer).getValueAsObject());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); given PDExtendedGraphicsState() Transfer is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_givenPDExtendedGraphicsStateTransferIsFalse() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer(COSBoolean.FALSE);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    COSBase transfer = gs.getTransfer();
    assertTrue(transfer instanceof COSBoolean);
    assertNull(transfer.getKey());
    assertFalse(transfer.isDirect());
    assertFalse(((COSBoolean) transfer).getValue());
    assertFalse(((COSBoolean) transfer).getValueAsObject());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} AlphaSource.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 AlphaSource")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0AlphaSource() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAlphaSourceFlag(true);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertTrue(gs.isAlphaSource());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} LineCap is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 LineCap is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0LineCapIsOne() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineCapStyle(1);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(1, gs.getLineCap());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} LineJoin is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 LineJoin is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0LineJoinIsOne() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineJoinStyle(1);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(1, gs.getLineJoin());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} NonStrokingOverprint.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 NonStrokingOverprint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0NonStrokingOverprint()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setNonStrokingOverprintControl(true);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertTrue(gs.isNonStrokingOverprint());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} Overprint.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 Overprint")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0Overprint() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(true);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertTrue(gs.isOverprint());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} OverprintMode is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 OverprintMode is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0OverprintModeIsOne()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setOverprintMode(1);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertEquals(1, gs.getOverprintMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} StrokeAdjustment.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 StrokeAdjustment")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0StrokeAdjustment()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAutomaticStrokeAdjustment(true);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(0.0f, textState.getFontSize());
    assertTrue(gs.isStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} TextState FontSize is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 TextState FontSize is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0TextStateFontSizeIsOne()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setFontSetting(new PDFontSetting());
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    assertNull(gs.getTransfer());
    PDTextState textState = gs.getTextState();
    assertNull(textState.getFont());
    assertNull(gs.getRenderingIntent());
    assertEquals(1.0f, textState.getFontSize());
  }

  /**
   * Test {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}.
   *
   * <ul>
   *   <li>Then {@link PDGraphicsState#PDGraphicsState(PDRectangle)} with page is {@link
   *       PDRectangle#A0} Transfer {@link COSBoolean}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#copyIntoGraphicsState(PDGraphicsState)}
   */
  @Test
  @DisplayName(
      "Test copyIntoGraphicsState(PDGraphicsState); then PDGraphicsState(PDRectangle) with page is A0 Transfer COSBoolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.copyIntoGraphicsState(PDGraphicsState)"})
  void testCopyIntoGraphicsState_thenPDGraphicsStateWithPageIsA0TransferCOSBoolean()
      throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer2(COSBoolean.FALSE);
    PDGraphicsState gs = new PDGraphicsState(PDRectangle.A0);

    // Act
    pdExtendedGraphicsState.copyIntoGraphicsState(gs);

    // Assert
    COSBase transfer = gs.getTransfer();
    assertTrue(transfer instanceof COSBoolean);
    assertNull(transfer.getKey());
    assertFalse(transfer.isDirect());
    assertFalse(((COSBoolean) transfer).getValue());
    assertFalse(((COSBoolean) transfer).getValueAsObject());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getCOSObject()}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDExtendedGraphicsState.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDExtendedGraphicsState().getCOSObject();

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
   * Test {@link PDExtendedGraphicsState#getLineWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getLineWidth()"})
  void testGetLineWidth_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getLineWidth());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineWidth(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineWidth(Float)}
   */
  @Test
  @DisplayName(
      "Test setLineWidth(Float); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineWidth(Float)"})
  void testSetLineWidth_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineWidth(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineWidth(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineWidth floatValue is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineWidth(Float)}
   */
  @Test
  @DisplayName(
      "Test setLineWidth(Float); then PDExtendedGraphicsState() LineWidth floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineWidth(Float)"})
  void testSetLineWidth_thenPDExtendedGraphicsStateLineWidthFloatValueIsTen() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getLineWidth().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineCapStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineCapStyle is minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineCapStyle()}
   */
  @Test
  @DisplayName("Test getLineCapStyle(); given PDExtendedGraphicsState() LineCapStyle is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDExtendedGraphicsState.getLineCapStyle()"})
  void testGetLineCapStyle_givenPDExtendedGraphicsStateLineCapStyleIsMinusOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineCapStyle(-1);

    // Act and Assert
    assertEquals(-1, pdExtendedGraphicsState.getLineCapStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineCapStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineCapStyle()}
   */
  @Test
  @DisplayName("Test getLineCapStyle(); given PDExtendedGraphicsState(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDExtendedGraphicsState.getLineCapStyle()"})
  void testGetLineCapStyle_givenPDExtendedGraphicsState_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDExtendedGraphicsState().getLineCapStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineCapStyle(int)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineCapStyle is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineCapStyle(int)}
   */
  @Test
  @DisplayName(
      "Test setLineCapStyle(int); then PDExtendedGraphicsState() LineCapStyle is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineCapStyle(int)"})
  void testSetLineCapStyle_thenPDExtendedGraphicsStateLineCapStyleIsMin_value() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineCapStyle(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdExtendedGraphicsState.getLineCapStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineCapStyle(int)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineCapStyle is minus one
   *       hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineCapStyle(int)}
   */
  @Test
  @DisplayName(
      "Test setLineCapStyle(int); then PDExtendedGraphicsState() LineCapStyle is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineCapStyle(int)"})
  void testSetLineCapStyle_thenPDExtendedGraphicsStateLineCapStyleIsMinusOneHundred() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineCapStyle(-100);

    // Assert
    assertEquals(-100, pdExtendedGraphicsState.getLineCapStyle());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineCapStyle(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineCapStyle is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineCapStyle(int)}
   */
  @Test
  @DisplayName(
      "Test setLineCapStyle(int); when one; then PDExtendedGraphicsState() LineCapStyle is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineCapStyle(int)"})
  void testSetLineCapStyle_whenOne_thenPDExtendedGraphicsStateLineCapStyleIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineCapStyle(1);

    // Assert
    assertEquals(1, pdExtendedGraphicsState.getLineCapStyle());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineJoinStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineJoinStyle is minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineJoinStyle()}
   */
  @Test
  @DisplayName(
      "Test getLineJoinStyle(); given PDExtendedGraphicsState() LineJoinStyle is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDExtendedGraphicsState.getLineJoinStyle()"})
  void testGetLineJoinStyle_givenPDExtendedGraphicsStateLineJoinStyleIsMinusOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineJoinStyle(-1);

    // Act and Assert
    assertEquals(-1, pdExtendedGraphicsState.getLineJoinStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineJoinStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineJoinStyle()}
   */
  @Test
  @DisplayName("Test getLineJoinStyle(); given PDExtendedGraphicsState(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDExtendedGraphicsState.getLineJoinStyle()"})
  void testGetLineJoinStyle_givenPDExtendedGraphicsState_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDExtendedGraphicsState().getLineJoinStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineJoinStyle(int)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineJoinStyle is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineJoinStyle(int)}
   */
  @Test
  @DisplayName(
      "Test setLineJoinStyle(int); then PDExtendedGraphicsState() LineJoinStyle is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineJoinStyle(int)"})
  void testSetLineJoinStyle_thenPDExtendedGraphicsStateLineJoinStyleIsMin_value() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineJoinStyle(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdExtendedGraphicsState.getLineJoinStyle());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineJoinStyle(int)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} LineJoinStyle is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineJoinStyle(int)}
   */
  @Test
  @DisplayName("Test setLineJoinStyle(int); then PDExtendedGraphicsState() LineJoinStyle is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineJoinStyle(int)"})
  void testSetLineJoinStyle_thenPDExtendedGraphicsStateLineJoinStyleIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineJoinStyle(1);

    // Assert
    assertEquals(1, pdExtendedGraphicsState.getLineJoinStyle());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getMiterLimit()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getMiterLimit()}
   */
  @Test
  @DisplayName("Test getMiterLimit(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getMiterLimit()"})
  void testGetMiterLimit_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getMiterLimit());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setMiterLimit(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setMiterLimit(Float)}
   */
  @Test
  @DisplayName(
      "Test setMiterLimit(Float); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setMiterLimit(Float)"})
  void testSetMiterLimit_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setMiterLimit(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setMiterLimit(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} MiterLimit floatValue is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setMiterLimit(Float)}
   */
  @Test
  @DisplayName(
      "Test setMiterLimit(Float); then PDExtendedGraphicsState() MiterLimit floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setMiterLimit(Float)"})
  void testSetMiterLimit_thenPDExtendedGraphicsStateMiterLimitFloatValueIsTen() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setMiterLimit(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getMiterLimit().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineDashPattern()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineDashPattern()}
   */
  @Test
  @DisplayName("Test getLineDashPattern(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDLineDashPattern PDExtendedGraphicsState.getLineDashPattern()"})
  void testGetLineDashPattern_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getLineDashPattern());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getLineDashPattern()}.
   *
   * <ul>
   *   <li>Then return COSObject toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getLineDashPattern()}
   */
  @Test
  @DisplayName("Test getLineDashPattern(); then return COSObject toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDLineDashPattern PDExtendedGraphicsState.getLineDashPattern()"})
  void testGetLineDashPattern_thenReturnCOSObjectToListSizeIsTwo() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setLineDashPattern(new PDLineDashPattern());

    // Act
    PDLineDashPattern actualLineDashPattern = pdExtendedGraphicsState.getLineDashPattern();

    // Assert
    COSBase cOSObject = actualLineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertEquals(0, actualLineDashPattern.getPhase());
    assertFalse(getResult2.isDirect());
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertArrayEquals(new float[] {}, actualLineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDExtendedGraphicsState#setLineDashPattern(PDLineDashPattern)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setLineDashPattern(PDLineDashPattern)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(PDLineDashPattern)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setLineDashPattern(PDLineDashPattern)"})
  void testSetLineDashPattern() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setLineDashPattern(new PDLineDashPattern());

    // Assert
    PDLineDashPattern lineDashPattern = pdExtendedGraphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, lineDashPattern.getPhase());
    COSDictionary cOSObject2 = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDExtendedGraphicsState#getRenderingIntent()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getRenderingIntent()}
   */
  @Test
  @DisplayName("Test getRenderingIntent(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingIntent PDExtendedGraphicsState.getRenderingIntent()"})
  void testGetRenderingIntent_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getRenderingIntent()}.
   *
   * <ul>
   *   <li>Then return {@code ABSOLUTE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getRenderingIntent()}
   */
  @Test
  @DisplayName("Test getRenderingIntent(); then return 'ABSOLUTE_COLORIMETRIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingIntent PDExtendedGraphicsState.getRenderingIntent()"})
  void testGetRenderingIntent_thenReturnAbsoluteColorimetric() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setRenderingIntent("AbsoluteColorimetric");

    // Act and Assert
    assertEquals(
        RenderingIntent.ABSOLUTE_COLORIMETRIC, pdExtendedGraphicsState.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getRenderingIntent()}.
   *
   * <ul>
   *   <li>Then return {@code RELATIVE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getRenderingIntent()}
   */
  @Test
  @DisplayName("Test getRenderingIntent(); then return 'RELATIVE_COLORIMETRIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderingIntent PDExtendedGraphicsState.getRenderingIntent()"})
  void testGetRenderingIntent_thenReturnRelativeColorimetric() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setRenderingIntent("RI");

    // Act and Assert
    assertEquals(
        RenderingIntent.RELATIVE_COLORIMETRIC, pdExtendedGraphicsState.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setRenderingIntent(String)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setRenderingIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setRenderingIntent(String); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setRenderingIntent(String)"})
  void testSetRenderingIntent_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setRenderingIntent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setRenderingIntent(String)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setRenderingIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setRenderingIntent(String); then PDExtendedGraphicsState() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setRenderingIntent(String)"})
  void testSetRenderingIntent_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setRenderingIntent("Ri");

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        RenderingIntent.RELATIVE_COLORIMETRIC, pdExtendedGraphicsState.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setRenderingIntent(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setRenderingIntent(String)}
   */
  @Test
  @DisplayName("Test setRenderingIntent(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setRenderingIntent(String)"})
  void testSetRenderingIntent_when42() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setRenderingIntent("42");

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        RenderingIntent.RELATIVE_COLORIMETRIC, pdExtendedGraphicsState.getRenderingIntent());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getStrokingOverprintControl()}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getStrokingOverprintControl()}
   */
  @Test
  @DisplayName("Test getStrokingOverprintControl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getStrokingOverprintControl()"})
  void testGetStrokingOverprintControl() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(false);

    // Act and Assert
    assertFalse(pdExtendedGraphicsState.getStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getStrokingOverprintControl()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getStrokingOverprintControl()}
   */
  @Test
  @DisplayName(
      "Test getStrokingOverprintControl(); given PDExtendedGraphicsState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getStrokingOverprintControl()"})
  void testGetStrokingOverprintControl_givenPDExtendedGraphicsState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDExtendedGraphicsState().getStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getStrokingOverprintControl()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getStrokingOverprintControl()}
   */
  @Test
  @DisplayName("Test getStrokingOverprintControl(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getStrokingOverprintControl()"})
  void testGetStrokingOverprintControl_thenReturnTrue() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(true);

    // Act and Assert
    assertTrue(pdExtendedGraphicsState.getStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setStrokingOverprintControl(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setStrokingOverprintControl(boolean)}
   */
  @Test
  @DisplayName("Test setStrokingOverprintControl(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setStrokingOverprintControl(boolean)"})
  void testSetStrokingOverprintControl() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setStrokingOverprintControl(true);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdExtendedGraphicsState.getNonStrokingOverprintControl());
    assertTrue(pdExtendedGraphicsState.getStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setStrokingOverprintControl(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setStrokingOverprintControl(boolean)}
   */
  @Test
  @DisplayName("Test setStrokingOverprintControl(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setStrokingOverprintControl(boolean)"})
  void testSetStrokingOverprintControl2() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setStrokingOverprintControl(false);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExtendedGraphicsState.getNonStrokingOverprintControl());
    assertFalse(pdExtendedGraphicsState.getStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}
   */
  @Test
  @DisplayName("Test getNonStrokingOverprintControl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getNonStrokingOverprintControl()"})
  void testGetNonStrokingOverprintControl() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(false);

    // Act and Assert
    assertFalse(pdExtendedGraphicsState.getNonStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}
   */
  @Test
  @DisplayName(
      "Test getNonStrokingOverprintControl(); given PDExtendedGraphicsState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getNonStrokingOverprintControl()"})
  void testGetNonStrokingOverprintControl_givenPDExtendedGraphicsState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDExtendedGraphicsState().getNonStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getNonStrokingOverprintControl()}
   */
  @Test
  @DisplayName("Test getNonStrokingOverprintControl(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getNonStrokingOverprintControl()"})
  void testGetNonStrokingOverprintControl_thenReturnTrue() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setStrokingOverprintControl(true);

    // Act and Assert
    assertTrue(pdExtendedGraphicsState.getNonStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setNonStrokingOverprintControl(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setNonStrokingOverprintControl(boolean)}
   */
  @Test
  @DisplayName("Test setNonStrokingOverprintControl(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setNonStrokingOverprintControl(boolean)"})
  void testSetNonStrokingOverprintControl() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setNonStrokingOverprintControl(true);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdExtendedGraphicsState.getNonStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setNonStrokingOverprintControl(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setNonStrokingOverprintControl(boolean)}
   */
  @Test
  @DisplayName("Test setNonStrokingOverprintControl(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setNonStrokingOverprintControl(boolean)"})
  void testSetNonStrokingOverprintControl2() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setNonStrokingOverprintControl(false);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExtendedGraphicsState.getNonStrokingOverprintControl());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getOverprintMode()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getOverprintMode()}
   */
  @Test
  @DisplayName("Test getOverprintMode(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDExtendedGraphicsState.getOverprintMode()"})
  void testGetOverprintMode_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getOverprintMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getOverprintMode()}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getOverprintMode()}
   */
  @Test
  @DisplayName("Test getOverprintMode(); then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PDExtendedGraphicsState.getOverprintMode()"})
  void testGetOverprintMode_thenReturnIntValueIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setOverprintMode(1);

    // Act and Assert
    assertEquals(1, pdExtendedGraphicsState.getOverprintMode().intValue());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setOverprintMode(Integer)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setOverprintMode(Integer)}
   */
  @Test
  @DisplayName(
      "Test setOverprintMode(Integer); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setOverprintMode(Integer)"})
  void testSetOverprintMode_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setOverprintMode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setOverprintMode(Integer)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} OverprintMode intValue is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setOverprintMode(Integer)}
   */
  @Test
  @DisplayName(
      "Test setOverprintMode(Integer); then PDExtendedGraphicsState() OverprintMode intValue is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setOverprintMode(Integer)"})
  void testSetOverprintMode_thenPDExtendedGraphicsStateOverprintModeIntValueIsMin_value() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setOverprintMode(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdExtendedGraphicsState.getOverprintMode().intValue());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setOverprintMode(Integer)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} OverprintMode intValue is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setOverprintMode(Integer)}
   */
  @Test
  @DisplayName(
      "Test setOverprintMode(Integer); then PDExtendedGraphicsState() OverprintMode intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setOverprintMode(Integer)"})
  void testSetOverprintMode_thenPDExtendedGraphicsStateOverprintModeIntValueIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setOverprintMode(1);

    // Assert
    assertEquals(1, pdExtendedGraphicsState.getOverprintMode().intValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getFontSetting()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getFontSetting()}
   */
  @Test
  @DisplayName("Test getFontSetting(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontSetting PDExtendedGraphicsState.getFontSetting()"})
  void testGetFontSetting_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getFontSetting());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getFontSetting()}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getFontSetting()}
   */
  @Test
  @DisplayName("Test getFontSetting(); then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontSetting PDExtendedGraphicsState.getFontSetting()"})
  void testGetFontSetting_thenCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setFontSetting(new PDFontSetting());

    // Act
    PDFontSetting actualFontSetting = pdExtendedGraphicsState.getFontSetting();

    // Assert
    COSBase cOSObject = actualFontSetting.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(toListResult.get(0));
    assertNull(getResult.getKey());
    assertNull(actualFontSetting.getFont());
    assertEquals(1.0f, actualFontSetting.getFontSize());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setFontSetting(PDFontSetting)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} FontSetting Font is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setFontSetting(PDFontSetting)}
   */
  @Test
  @DisplayName(
      "Test setFontSetting(PDFontSetting); then PDExtendedGraphicsState() FontSetting Font is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setFontSetting(PDFontSetting)"})
  void testSetFontSetting_thenPDExtendedGraphicsStateFontSettingFontIsNull() throws IOException {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setFontSetting(new PDFontSetting());

    // Assert
    PDFontSetting fontSetting = pdExtendedGraphicsState.getFontSetting();
    assertNull(fontSetting.getFont());
    assertEquals(1.0f, fontSetting.getFontSize());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setFontSetting(PDFontSetting)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setFontSetting(PDFontSetting)}
   */
  @Test
  @DisplayName(
      "Test setFontSetting(PDFontSetting); when 'null'; then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setFontSetting(PDFontSetting)"})
  void testSetFontSetting_whenNull_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setFontSetting(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getFlatnessTolerance()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getFlatnessTolerance()}
   */
  @Test
  @DisplayName("Test getFlatnessTolerance(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getFlatnessTolerance()"})
  void testGetFlatnessTolerance_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getFlatnessTolerance());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setFlatnessTolerance(Float)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setFlatnessTolerance(Float)}
   */
  @Test
  @DisplayName("Test setFlatnessTolerance(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setFlatnessTolerance(Float)"})
  void testSetFlatnessTolerance() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setFlatnessTolerance(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getFlatnessTolerance().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setFlatnessTolerance(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setFlatnessTolerance(Float)}
   */
  @Test
  @DisplayName(
      "Test setFlatnessTolerance(Float); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setFlatnessTolerance(Float)"})
  void testSetFlatnessTolerance_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setFlatnessTolerance(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getSmoothnessTolerance()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getSmoothnessTolerance()}
   */
  @Test
  @DisplayName("Test getSmoothnessTolerance(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getSmoothnessTolerance()"})
  void testGetSmoothnessTolerance_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getSmoothnessTolerance());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setSmoothnessTolerance(Float)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setSmoothnessTolerance(Float)}
   */
  @Test
  @DisplayName("Test setSmoothnessTolerance(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setSmoothnessTolerance(Float)"})
  void testSetSmoothnessTolerance() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setSmoothnessTolerance(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getSmoothnessTolerance().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setSmoothnessTolerance(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setSmoothnessTolerance(Float)}
   */
  @Test
  @DisplayName(
      "Test setSmoothnessTolerance(Float); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setSmoothnessTolerance(Float)"})
  void testSetSmoothnessTolerance_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setSmoothnessTolerance(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}
   */
  @Test
  @DisplayName("Test getAutomaticStrokeAdjustment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAutomaticStrokeAdjustment()"})
  void testGetAutomaticStrokeAdjustment() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAutomaticStrokeAdjustment(false);

    // Act and Assert
    assertFalse(pdExtendedGraphicsState.getAutomaticStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}
   */
  @Test
  @DisplayName(
      "Test getAutomaticStrokeAdjustment(); given PDExtendedGraphicsState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAutomaticStrokeAdjustment()"})
  void testGetAutomaticStrokeAdjustment_givenPDExtendedGraphicsState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDExtendedGraphicsState().getAutomaticStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAutomaticStrokeAdjustment()}
   */
  @Test
  @DisplayName("Test getAutomaticStrokeAdjustment(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAutomaticStrokeAdjustment()"})
  void testGetAutomaticStrokeAdjustment_thenReturnTrue() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAutomaticStrokeAdjustment(true);

    // Act and Assert
    assertTrue(pdExtendedGraphicsState.getAutomaticStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setAutomaticStrokeAdjustment(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setAutomaticStrokeAdjustment(boolean)}
   */
  @Test
  @DisplayName("Test setAutomaticStrokeAdjustment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setAutomaticStrokeAdjustment(boolean)"})
  void testSetAutomaticStrokeAdjustment() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setAutomaticStrokeAdjustment(true);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdExtendedGraphicsState.getAutomaticStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setAutomaticStrokeAdjustment(boolean)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setAutomaticStrokeAdjustment(boolean)}
   */
  @Test
  @DisplayName("Test setAutomaticStrokeAdjustment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setAutomaticStrokeAdjustment(boolean)"})
  void testSetAutomaticStrokeAdjustment2() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setAutomaticStrokeAdjustment(false);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExtendedGraphicsState.getAutomaticStrokeAdjustment());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getStrokingAlphaConstant()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getStrokingAlphaConstant()}
   */
  @Test
  @DisplayName(
      "Test getStrokingAlphaConstant(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getStrokingAlphaConstant()"})
  void testGetStrokingAlphaConstant_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getStrokingAlphaConstant());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setStrokingAlphaConstant(Float)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setStrokingAlphaConstant(Float)}
   */
  @Test
  @DisplayName("Test setStrokingAlphaConstant(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setStrokingAlphaConstant(Float)"})
  void testSetStrokingAlphaConstant() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setStrokingAlphaConstant(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getStrokingAlphaConstant().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setStrokingAlphaConstant(Float)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setStrokingAlphaConstant(Float)}
   */
  @Test
  @DisplayName(
      "Test setStrokingAlphaConstant(Float); then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setStrokingAlphaConstant(Float)"})
  void testSetStrokingAlphaConstant_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setStrokingAlphaConstant(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getNonStrokingAlphaConstant()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getNonStrokingAlphaConstant()}
   */
  @Test
  @DisplayName(
      "Test getNonStrokingAlphaConstant(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float PDExtendedGraphicsState.getNonStrokingAlphaConstant()"})
  void testGetNonStrokingAlphaConstant_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getNonStrokingAlphaConstant());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setNonStrokingAlphaConstant(Float)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setNonStrokingAlphaConstant(Float)}
   */
  @Test
  @DisplayName("Test setNonStrokingAlphaConstant(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setNonStrokingAlphaConstant(Float)"})
  void testSetNonStrokingAlphaConstant() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setNonStrokingAlphaConstant(10.0f);

    // Assert
    assertEquals(10.0f, pdExtendedGraphicsState.getNonStrokingAlphaConstant().floatValue());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setNonStrokingAlphaConstant(Float)}.
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setNonStrokingAlphaConstant(Float)}
   */
  @Test
  @DisplayName("Test setNonStrokingAlphaConstant(Float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setNonStrokingAlphaConstant(Float)"})
  void testSetNonStrokingAlphaConstant2() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setNonStrokingAlphaConstant(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAlphaSourceFlag()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} AlphaSourceFlag is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAlphaSourceFlag()}
   */
  @Test
  @DisplayName(
      "Test getAlphaSourceFlag(); given PDExtendedGraphicsState() AlphaSourceFlag is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAlphaSourceFlag()"})
  void testGetAlphaSourceFlag_givenPDExtendedGraphicsStateAlphaSourceFlagIsFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAlphaSourceFlag(false);

    // Act and Assert
    assertFalse(pdExtendedGraphicsState.getAlphaSourceFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAlphaSourceFlag()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAlphaSourceFlag()}
   */
  @Test
  @DisplayName("Test getAlphaSourceFlag(); given PDExtendedGraphicsState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAlphaSourceFlag()"})
  void testGetAlphaSourceFlag_givenPDExtendedGraphicsState_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDExtendedGraphicsState().getAlphaSourceFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getAlphaSourceFlag()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getAlphaSourceFlag()}
   */
  @Test
  @DisplayName("Test getAlphaSourceFlag(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getAlphaSourceFlag()"})
  void testGetAlphaSourceFlag_thenReturnTrue() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setAlphaSourceFlag(true);

    // Act and Assert
    assertTrue(pdExtendedGraphicsState.getAlphaSourceFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setAlphaSourceFlag(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} AlphaSourceFlag.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setAlphaSourceFlag(boolean)}
   */
  @Test
  @DisplayName("Test setAlphaSourceFlag(boolean); then PDExtendedGraphicsState() AlphaSourceFlag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setAlphaSourceFlag(boolean)"})
  void testSetAlphaSourceFlag_thenPDExtendedGraphicsStateAlphaSourceFlag() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setAlphaSourceFlag(true);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdExtendedGraphicsState.getAlphaSourceFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setAlphaSourceFlag(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} AlphaSourceFlag.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setAlphaSourceFlag(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAlphaSourceFlag(boolean); when 'false'; then not PDExtendedGraphicsState() AlphaSourceFlag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setAlphaSourceFlag(boolean)"})
  void testSetAlphaSourceFlag_whenFalse_thenNotPDExtendedGraphicsStateAlphaSourceFlag() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setAlphaSourceFlag(false);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExtendedGraphicsState.getAlphaSourceFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getBlendMode()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} BlendMode is {@link
   *       BlendMode#COLOR}.
   *   <li>Then return {@link BlendMode#COLOR}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getBlendMode()}
   */
  @Test
  @DisplayName(
      "Test getBlendMode(); given PDExtendedGraphicsState() BlendMode is COLOR; then return COLOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlendMode PDExtendedGraphicsState.getBlendMode()"})
  void testGetBlendMode_givenPDExtendedGraphicsStateBlendModeIsColor_thenReturnColor() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setBlendMode(BlendMode.COLOR);

    // Act and Assert
    assertSame(BlendMode.COLOR, pdExtendedGraphicsState.getBlendMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getBlendMode()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@link BlendMode#NORMAL}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getBlendMode()}
   */
  @Test
  @DisplayName("Test getBlendMode(); given PDExtendedGraphicsState(); then return NORMAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlendMode PDExtendedGraphicsState.getBlendMode()"})
  void testGetBlendMode_givenPDExtendedGraphicsState_thenReturnNormal() {
    // Arrange, Act and Assert
    assertSame(BlendMode.NORMAL, new PDExtendedGraphicsState().getBlendMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setBlendMode(BlendMode)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setBlendMode(BlendMode)}
   */
  @Test
  @DisplayName(
      "Test setBlendMode(BlendMode); then PDExtendedGraphicsState() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setBlendMode(BlendMode)"})
  void testSetBlendMode_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setBlendMode(BlendMode.COLOR);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(BlendMode.COLOR, pdExtendedGraphicsState.getBlendMode());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getSoftMask()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getSoftMask()}
   */
  @Test
  @DisplayName("Test getSoftMask(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.state.PDSoftMask PDExtendedGraphicsState.getSoftMask()"
  })
  void testGetSoftMask_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getSoftMask());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTextKnockoutFlag()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} TextKnockoutFlag is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTextKnockoutFlag()}
   */
  @Test
  @DisplayName(
      "Test getTextKnockoutFlag(); given PDExtendedGraphicsState() TextKnockoutFlag is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getTextKnockoutFlag()"})
  void testGetTextKnockoutFlag_givenPDExtendedGraphicsStateTextKnockoutFlagIsTrue() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTextKnockoutFlag(true);

    // Act and Assert
    assertTrue(pdExtendedGraphicsState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTextKnockoutFlag()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTextKnockoutFlag()}
   */
  @Test
  @DisplayName("Test getTextKnockoutFlag(); given PDExtendedGraphicsState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getTextKnockoutFlag()"})
  void testGetTextKnockoutFlag_givenPDExtendedGraphicsState_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDExtendedGraphicsState().getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTextKnockoutFlag()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTextKnockoutFlag()}
   */
  @Test
  @DisplayName("Test getTextKnockoutFlag(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDExtendedGraphicsState.getTextKnockoutFlag()"})
  void testGetTextKnockoutFlag_thenReturnFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTextKnockoutFlag(false);

    // Act and Assert
    assertFalse(pdExtendedGraphicsState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTextKnockoutFlag(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} TextKnockoutFlag.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTextKnockoutFlag(boolean)}
   */
  @Test
  @DisplayName("Test setTextKnockoutFlag(boolean); then PDExtendedGraphicsState() TextKnockoutFlag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTextKnockoutFlag(boolean)"})
  void testSetTextKnockoutFlag_thenPDExtendedGraphicsStateTextKnockoutFlag() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTextKnockoutFlag(true);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdExtendedGraphicsState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTextKnockoutFlag(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} TextKnockoutFlag.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTextKnockoutFlag(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTextKnockoutFlag(boolean); when 'false'; then not PDExtendedGraphicsState() TextKnockoutFlag")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTextKnockoutFlag(boolean)"})
  void testSetTextKnockoutFlag_whenFalse_thenNotPDExtendedGraphicsStateTextKnockoutFlag() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTextKnockoutFlag(false);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdExtendedGraphicsState.getTextKnockoutFlag());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer()}
   */
  @Test
  @DisplayName(
      "Test getTransfer(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer()"})
  void testGetTransfer_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSObject transfer = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    pdExtendedGraphicsState.setTransfer(transfer);

    // Act
    COSBase actualTransfer = pdExtendedGraphicsState.getTransfer();

    // Assert
    assertSame(((COSBoolean) actualTransfer).FALSE, actualTransfer);
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer()}
   */
  @Test
  @DisplayName(
      "Test getTransfer(); given PDExtendedGraphicsState() Transfer is COSArray(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer()"})
  void testGetTransfer_givenPDExtendedGraphicsStateTransferIsCOSArray_thenReturnNull() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer(new COSArray());

    // Act and Assert
    assertNull(pdExtendedGraphicsState.getTransfer());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer()}
   */
  @Test
  @DisplayName("Test getTransfer(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer()"})
  void testGetTransfer_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getTransfer());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    COSDictionary transfer = new COSDictionary();
    transfer.setKey(new COSObjectKey(1L, 1));

    // Act
    pdExtendedGraphicsState.setTransfer(transfer);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(transfer, pdExtendedGraphicsState.getTransfer());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer(COSBase); when COSArray(); then PDExtendedGraphicsState() Transfer is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_whenCOSArray_thenPDExtendedGraphicsStateTransferIsNull() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer(new COSArray());

    // Assert
    assertNull(pdExtendedGraphicsState.getTransfer());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName("Test setTransfer(COSBase); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_whenCOSDictionary() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSDictionary transfer = new COSDictionary();

    // Act
    pdExtendedGraphicsState.setTransfer(transfer);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(transfer, pdExtendedGraphicsState.getTransfer());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSObject transfer = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdExtendedGraphicsState.setTransfer(transfer);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer(COSBase); when FALSE; then PDExtendedGraphicsState() Transfer is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_whenFalse_thenPDExtendedGraphicsStateTransferIsFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdExtendedGraphicsState.getTransfer());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer(COSBase); when 'null'; then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer(COSBase)"})
  void testSetTransfer_whenNull_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer2()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer2()}
   */
  @Test
  @DisplayName(
      "Test getTransfer2(); given COSObjectKey(long, int) with num is one and gen is one; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer2()"})
  void testGetTransfer2_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSObject transfer2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    pdExtendedGraphicsState.setTransfer2(transfer2);

    // Act
    COSBase actualTransfer2 = pdExtendedGraphicsState.getTransfer2();

    // Assert
    assertSame(((COSBoolean) actualTransfer2).FALSE, actualTransfer2);
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer2()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer2 is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer2()}
   */
  @Test
  @DisplayName(
      "Test getTransfer2(); given PDExtendedGraphicsState() Transfer2 is COSArray(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer2()"})
  void testGetTransfer2_givenPDExtendedGraphicsStateTransfer2IsCOSArray_thenReturnNull() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    pdExtendedGraphicsState.setTransfer2(new COSArray());

    // Act and Assert
    assertNull(pdExtendedGraphicsState.getTransfer2());
  }

  /**
   * Test {@link PDExtendedGraphicsState#getTransfer2()}.
   *
   * <ul>
   *   <li>Given {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#getTransfer2()}
   */
  @Test
  @DisplayName("Test getTransfer2(); given PDExtendedGraphicsState(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDExtendedGraphicsState.getTransfer2()"})
  void testGetTransfer2_givenPDExtendedGraphicsState_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExtendedGraphicsState().getTransfer2());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer2(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    COSDictionary transfer2 = new COSDictionary();
    transfer2.setKey(new COSObjectKey(1L, 1));

    // Act
    pdExtendedGraphicsState.setTransfer2(transfer2);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(transfer2, pdExtendedGraphicsState.getTransfer2());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer2 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer2(COSBase); when COSArray(); then PDExtendedGraphicsState() Transfer2 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_whenCOSArray_thenPDExtendedGraphicsStateTransfer2IsNull() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer2(new COSArray());

    // Assert
    assertNull(pdExtendedGraphicsState.getTransfer2());
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName("Test setTransfer2(COSBase); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_whenCOSDictionary() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSDictionary transfer2 = new COSDictionary();

    // Act
    pdExtendedGraphicsState.setTransfer2(transfer2);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(transfer2, pdExtendedGraphicsState.getTransfer2());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer2(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();
    COSObject transfer2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdExtendedGraphicsState.setTransfer2(transfer2);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} Transfer2 is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer2(COSBase); when FALSE; then PDExtendedGraphicsState() Transfer2 is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_whenFalse_thenPDExtendedGraphicsStateTransfer2IsFalse() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer2(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdExtendedGraphicsState.getTransfer2());
  }

  /**
   * Test {@link PDExtendedGraphicsState#setTransfer2(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDExtendedGraphicsState#PDExtendedGraphicsState()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExtendedGraphicsState#setTransfer2(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setTransfer2(COSBase); when 'null'; then PDExtendedGraphicsState() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExtendedGraphicsState.setTransfer2(COSBase)"})
  void testSetTransfer2_whenNull_thenPDExtendedGraphicsStateCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExtendedGraphicsState pdExtendedGraphicsState = new PDExtendedGraphicsState();

    // Act
    pdExtendedGraphicsState.setTransfer2(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExtendedGraphicsState.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
