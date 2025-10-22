package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetNonStrokingColorSpaceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetNonStrokingColorSpace#SetNonStrokingColorSpace(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColorSpace#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.<init>(PDFStreamEngine)",
      "java.lang.String SetNonStrokingColorSpace.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("cs", (new SetNonStrokingColorSpace(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() A is INSTANCE; then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAIsInstance_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDDeviceRGB#INSTANCE}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() A is INSTANCE; then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAIsInstance_thenCallsGetGraphicsState2() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceRGB.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() A is PDCalGray(); then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAIsPDCalGray_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalGray());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDCalRGB#PDCalRGB()}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() A is PDCalRGB(); then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAIsPDCalRGB_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDCalRGB());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@link COSName#A} is {@link PDLab#PDLab()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() A is PDLab(); when ArrayList() add A; then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesAIsPDLab_whenArrayListAddA_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDLab());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} {@code null} is {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDResources() 'null' is INSTANCE; then calls getGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_givenPDResourcesNullIsInstance_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
  }

  /**
   * Test {@link SetNonStrokingColorSpace#process(Operator, List)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColorSpace.process(Operator, List)"})
  void testProcess_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = mock(COSDictionary.class);
    when(resourceDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(resourceDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
  }
}
