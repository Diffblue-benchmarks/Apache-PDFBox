package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceN;
import org.apache.pdfbox.pdmodel.graphics.color.PDIndexed;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDSeparation;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetNonStrokingColorSpaceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetNonStrokingColorSpace#SetNonStrokingColorSpace(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColorSpace#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetNonStrokingColorSpace.<init>(PDFStreamEngine)",
    "java.lang.String SetNonStrokingColorSpace.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("cs", new SetNonStrokingColorSpace(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess2() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any()))
        .thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#getResources()} return {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine getResources() return PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineGetResourcesReturnPDResources() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDDeviceGray#INSTANCE}.
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources() add INSTANCE; then calls getGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAddInstance_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDDeviceGray#INSTANCE}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return INSTANCE; then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnInstance_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(PDDeviceGray.INSTANCE);

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDCalGray#PDCalGray()}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDCalGray(); then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDCalGray_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDCalGray());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDCalRGB#PDCalRGB()}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDCalRGB(); then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDCalRGB_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDCalRGB());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDDeviceN#PDDeviceN()}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDDeviceN(); then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDDeviceN_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDDeviceN());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDIndexed#PDIndexed()}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDIndexed(); then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDIndexed_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDIndexed());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDLab#PDLab()}.
   *   <li>Then calls {@link PDResources#getColorSpace(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDLab(); then calls getColorSpace(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDLab_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDLab());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getColorSpace(COSName)} return {@link
   *       PDSeparation#PDSeparation()}.
   * </ul>
   *
   * <p>Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDResources getColorSpace(COSName) return PDSeparation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesGetColorSpaceReturnPDSeparation() throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getColorSpace(Mockito.<COSName>any())).thenReturn(new PDSeparation());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.DEVICECMYK);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(pdResources).getColorSpace(isA(COSName.class));
  }
}
