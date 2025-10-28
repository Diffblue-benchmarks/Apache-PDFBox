package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.jupiter.api.Test;

class SetNonStrokingColorDiffblueTest {
  /**
   * Method under test: {@link SetNonStrokingColor#setColor(PDColor)}
   */
  @Test
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
   * Method under test: {@link SetNonStrokingColor#getColorSpace()}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());

    // Act
    PDColorSpace actualColorSpace = (new SetNonStrokingColor(context)).getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link SetNonStrokingColor#getColorSpace()}
   */
  @Test
  void testGetColorSpace2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream contents = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDPage page = new PDPage();
    page.setContents(contents);

    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(page);

    // Act
    PDColorSpace actualColorSpace = (new SetNonStrokingColor(context)).getColorSpace();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetNonStrokingColor#SetNonStrokingColor(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColor#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("sc", (new SetNonStrokingColor(new PDFMarkedContentExtractor())).getName());
  }
}
