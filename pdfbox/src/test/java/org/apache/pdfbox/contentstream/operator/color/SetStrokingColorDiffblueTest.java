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

class SetStrokingColorDiffblueTest {
  /**
   * Method under test: {@link SetStrokingColor#setColor(PDColor)}
   */
  @Test
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
   * Method under test: {@link SetStrokingColor#getColorSpace()}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange
    PDFTextStripperByArea context = new PDFTextStripperByArea();
    context.processPage(new PDPage());

    // Act
    PDColorSpace actualColorSpace = (new SetStrokingColor(context)).getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link SetStrokingColor#getColorSpace()}
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
    PDColorSpace actualColorSpace = (new SetStrokingColor(context)).getColorSpace();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetStrokingColor#SetStrokingColor(PDFStreamEngine)}
   *   <li>{@link SetStrokingColor#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SC", (new SetStrokingColor(new PDFMarkedContentExtractor())).getName());
  }
}
