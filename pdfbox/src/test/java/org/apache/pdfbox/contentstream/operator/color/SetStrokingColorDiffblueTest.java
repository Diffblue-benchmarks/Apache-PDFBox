package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetStrokingColorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetStrokingColor#SetStrokingColor(PDFStreamEngine)}
   *   <li>{@link SetStrokingColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetStrokingColor.<init>(PDFStreamEngine)",
    "java.lang.String SetStrokingColor.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SC", new SetStrokingColor(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetStrokingColor#setColor(PDColor)}.
   *
   * <p>Method under test: {@link SetStrokingColor#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetStrokingColor.setColor(PDColor)"})
  void testSetColor() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetStrokingColor setStrokingColor = new SetStrokingColor(context);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    setStrokingColor.setColor(color);

    // Assert
    verify(context).getGraphicsState();
    assertSame(color, setStrokingColor.getColor());
  }

  /**
   * Test {@link SetStrokingColor#getColorSpace()}.
   *
   * <ul>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link SetStrokingColor#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace SetStrokingColor.getColorSpace()"})
  void testGetColorSpace_thenReturnInstance() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));

    // Act
    PDColorSpace actualColorSpace = new SetStrokingColor(context).getColorSpace();

    // Assert
    verify(context).getGraphicsState();
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }
}
