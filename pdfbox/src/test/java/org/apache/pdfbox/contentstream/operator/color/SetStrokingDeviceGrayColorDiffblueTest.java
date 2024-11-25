package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetStrokingDeviceGrayColorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SetStrokingDeviceGrayColor#SetStrokingDeviceGrayColor(PDFStreamEngine)}
   *   <li>{@link SetStrokingDeviceGrayColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
    assertEquals(0, color.getComponents().length);
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetStrokingDeviceGrayColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetStrokingDeviceGrayColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
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
    assertEquals(0, color.getComponents().length);
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }
}
