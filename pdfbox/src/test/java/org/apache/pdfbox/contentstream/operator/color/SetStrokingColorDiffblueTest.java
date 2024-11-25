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
import java.io.IOException;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetStrokingColorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetStrokingColor#SetStrokingColor(PDFStreamEngine)}
   *   <li>{@link SetStrokingColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SC", (new SetStrokingColor(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetStrokingColor#getColor()}.
   * <ul>
   *   <li>Then ColorSpace COSObject return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetStrokingColor#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then ColorSpace COSObject return COSName")
  void testGetColor_thenColorSpaceCOSObjectReturnCOSName() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());

    // Act
    PDColor actualColor = (new SetStrokingColor(context)).getColor();

    // Assert
    PDColorSpace colorSpace = actualColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", colorSpace.getName());
    assertNull(actualColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualColor.isPattern());
    assertSame(actualColor, colorSpace.getInitialColor());
    assertArrayEquals(new float[]{0.0f}, actualColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetStrokingColor#setColor(PDColor)}.
   * <p>
   * Method under test: {@link SetStrokingColor#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor)")
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
   * <ul>
   *   <li>Given {@link PDFTextStripperByArea#PDFTextStripperByArea()} processPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetStrokingColor#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDFTextStripperByArea() processPage PDPage(); then return INSTANCE")
  void testGetColorSpace_givenPDFTextStripperByAreaProcessPagePDPage_thenReturnInstance() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());

    // Act
    PDColorSpace actualColorSpace = (new SetStrokingColor(context)).getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }
}
