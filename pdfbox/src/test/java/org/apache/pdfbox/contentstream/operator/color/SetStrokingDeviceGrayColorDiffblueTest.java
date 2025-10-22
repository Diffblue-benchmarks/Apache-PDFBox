package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDICCBased;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetStrokingDeviceGrayColorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetStrokingDeviceGrayColor#SetStrokingDeviceGrayColor(PDFStreamEngine)}
   *   <li>{@link SetStrokingDeviceGrayColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetStrokingDeviceGrayColor.<init>(PDFStreamEngine)",
      "java.lang.String SetStrokingDeviceGrayColor.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("G", (new SetStrokingDeviceGrayColor(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetStrokingDeviceGrayColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetStrokingDeviceGrayColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetStrokingDeviceGrayColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetStrokingDeviceGrayColor setStrokingDeviceGrayColor = new SetStrokingDeviceGrayColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    setStrokingDeviceGrayColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    PDColorSpace colorSpace = setStrokingDeviceGrayColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setStrokingDeviceGrayColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetStrokingDeviceGrayColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetStrokingDeviceGrayColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetStrokingDeviceGrayColor.process(Operator, List)"})
  void testProcess2() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(new PDResources());
    SetStrokingDeviceGrayColor setStrokingDeviceGrayColor = new SetStrokingDeviceGrayColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    setStrokingDeviceGrayColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    PDColorSpace colorSpace = setStrokingDeviceGrayColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setStrokingDeviceGrayColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetStrokingDeviceGrayColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetStrokingDeviceGrayColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetStrokingDeviceGrayColor.process(Operator, List)"})
  void testProcess3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any()))
        .thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSDictionary resourceDictionary = mock(COSDictionary.class);
    when(resourceDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    ResourceCache resourceCache = mock(ResourceCache.class);
    PDICCBased pdiccBased = new PDICCBased(new PDDocument());
    when(resourceCache.getColorSpace(Mockito.<COSObject>any())).thenReturn(pdiccBased);
    PDResources pdResources = new PDResources(resourceDictionary, resourceCache);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetStrokingDeviceGrayColor setStrokingDeviceGrayColor = new SetStrokingDeviceGrayColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    setStrokingDeviceGrayColor.process(operator, new ArrayList<>());

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(resourceDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getItem(isA(COSName.class));
    verify(resourceCache).getColorSpace(isA(COSObject.class));
    assertSame(pdiccBased, setStrokingDeviceGrayColor.getColorSpace());
    assertSame(pdiccBased, setStrokingDeviceGrayColor.getColor().getColorSpace());
  }
}
