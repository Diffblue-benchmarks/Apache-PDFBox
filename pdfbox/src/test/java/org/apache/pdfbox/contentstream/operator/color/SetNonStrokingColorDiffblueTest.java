package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetNonStrokingColorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetNonStrokingColor#SetNonStrokingColor(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColor#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColor.<init>(PDFStreamEngine)",
      "java.lang.String SetNonStrokingColor.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("sc", (new SetNonStrokingColor(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetNonStrokingColor#setColor(PDColor)}.
   * <p>
   * Method under test: {@link SetNonStrokingColor#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetNonStrokingColor.setColor(PDColor)"})
  void testSetColor() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    setNonStrokingColor.setColor(color);

    // Assert
    verify(context).getGraphicsState();
    assertSame(color, setNonStrokingColor.getColor());
  }

  /**
   * Test {@link SetNonStrokingColor#getColorSpace()}.
   * <ul>
   *   <li>Given {@link PDFTextStripperByArea#PDFTextStripperByArea()} processPage {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetNonStrokingColor#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given PDFTextStripperByArea() processPage PDPage(); then return INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace SetNonStrokingColor.getColorSpace()"})
  void testGetColorSpace_givenPDFTextStripperByAreaProcessPagePDPage_thenReturnInstance() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());

    // Act
    PDColorSpace actualColorSpace = (new SetNonStrokingColor(context)).getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }
}
