package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetColorDiffblueTest {
  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(null);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    PDColorSpace colorSpace = setNonStrokingColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    PDColorSpace colorSpace = setNonStrokingColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertFalse(initialColor.isPattern());
    PDColor color = setNonStrokingColor.getColor();
    assertSame(colorSpace, color.getColorSpace());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {1.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne2() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    PDColorSpace colorSpace = setNonStrokingColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertFalse(initialColor.isPattern());
    PDColor color = setNonStrokingColor.getColor();
    assertSame(colorSpace, color.getColorSpace());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {1.0f}, color.getComponents(), 0.0f);
  }
}
