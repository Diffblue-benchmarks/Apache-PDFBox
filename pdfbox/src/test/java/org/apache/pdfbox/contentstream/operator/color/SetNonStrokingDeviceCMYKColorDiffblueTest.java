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
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
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

class SetNonStrokingDeviceCMYKColorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetNonStrokingDeviceCMYKColor#SetNonStrokingDeviceCMYKColor(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingDeviceCMYKColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetNonStrokingDeviceCMYKColor.<init>(PDFStreamEngine)",
    "java.lang.String SetNonStrokingDeviceCMYKColor.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("k", new SetNonStrokingDeviceCMYKColor(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess2() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingDeviceCMYKColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getColorSpace(isA(COSName.class));
    PDColorSpace colorSpace = setNonStrokingDeviceCMYKColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingDeviceCMYKColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess3() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingDeviceCMYKColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getColorSpace(isA(COSName.class));
    PDColorSpace colorSpace = setNonStrokingDeviceCMYKColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingDeviceCMYKColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources() add INSTANCE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess_givenPDResourcesAddInstance_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link
   *       PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#add(PDFont)} return {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link PDResources#add(PDFont)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources add(PDFont) return A; when ArrayList(); then calls add(PDFont)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess_givenPDResourcesAddReturnA_whenArrayList_thenCallsAdd() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#getResources()} return {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer getResources() return PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingDeviceCMYKColor.process(Operator, List)"})
  void testProcess_givenPageDrawerGetResourcesReturnPDResources() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor =
        new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>()));
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }
}
