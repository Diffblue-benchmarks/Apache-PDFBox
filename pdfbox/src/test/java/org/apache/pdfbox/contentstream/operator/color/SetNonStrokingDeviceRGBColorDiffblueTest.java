package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetNonStrokingDeviceRGBColorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetNonStrokingDeviceRGBColor#SetNonStrokingDeviceRGBColor(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingDeviceRGBColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetNonStrokingDeviceRGBColor.<init>(PDFStreamEngine)",
    "java.lang.String SetNonStrokingDeviceRGBColor.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("rg", new SetNonStrokingDeviceRGBColor(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess2() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingDeviceRGBColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
    PDColorSpace colorSpace = setNonStrokingDeviceRGBColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingDeviceRGBColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, arguments));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException2()
      throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, arguments));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources() add INSTANCE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess_givenPDResourcesAddInstance_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDDeviceGray#INSTANCE}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return INSTANCE; then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnInstance_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#getResources()} return {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceRGBColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer getResources() return PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceRGBColor.process(Operator, List)"})
  void testProcess_givenPageDrawerGetResourcesReturnPDResources() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetNonStrokingDeviceRGBColor setNonStrokingDeviceRGBColor =
        new SetNonStrokingDeviceRGBColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceRGBColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }
}
