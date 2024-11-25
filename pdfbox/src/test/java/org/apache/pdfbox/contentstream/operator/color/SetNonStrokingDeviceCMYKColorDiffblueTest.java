package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetNonStrokingDeviceCMYKColorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SetNonStrokingDeviceCMYKColor#SetNonStrokingDeviceCMYKColor(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingDeviceCMYKColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("k", (new SetNonStrokingDeviceCMYKColor(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}.
   * <ul>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SetNonStrokingDeviceCMYKColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then array length is zero")
  void testProcess_thenArrayLengthIsZero() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getItem(Mockito.<COSName>any()))
        .thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSDictionary resourceDictionary = mock(COSDictionary.class);
    when(resourceDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    ResourceCache resourceCache = mock(ResourceCache.class);
    PDPattern pdPattern = new PDPattern(new PDResources());
    when(resourceCache.getColorSpace(Mockito.<COSObject>any())).thenReturn(pdPattern);
    PDResources pdResources = new PDResources(resourceDictionary, resourceCache);

    PageDrawer context = mock(PageDrawer.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    when(context.getResources()).thenReturn(pdResources);
    SetNonStrokingDeviceCMYKColor setNonStrokingDeviceCMYKColor = new SetNonStrokingDeviceCMYKColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    setNonStrokingDeviceCMYKColor.process(operator, new ArrayList<>());

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(context).getResources();
    verify(resourceDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getItem(isA(COSName.class));
    verify(resourceCache).getColorSpace(isA(COSObject.class));
    PDColor color = setNonStrokingDeviceCMYKColor.getColor();
    assertEquals(0, color.getComponents().length);
    assertSame(pdPattern, setNonStrokingDeviceCMYKColor.getColorSpace());
    assertSame(pdPattern, color.getColorSpace());
  }
}
