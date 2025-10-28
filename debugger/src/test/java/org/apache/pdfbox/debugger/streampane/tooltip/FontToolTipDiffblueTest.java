package org.apache.pdfbox.debugger.streampane.tooltip;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.jupiter.api.Test;

class FontToolTipDiffblueTest {
  /**
   * Method under test: {@link FontToolTip#getToolTipText()}
   */
  @Test
  void testGetToolTipText() {
    // Arrange, Act and Assert
    assertNull((new FontToolTip(new PDResources(), "Row Text")).getToolTipText());
  }

  /**
   * Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  void testNewFontToolTip() {
    // Arrange, Act and Assert
    assertNull((new FontToolTip(new PDResources(), "Row Text")).getToolTipText());
  }

  /**
   * Method under test: {@link FontToolTip#FontToolTip(PDResources, String)}
   */
  @Test
  void testNewFontToolTip2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDImageXObject image = new PDImageXObject(new PDDocument(streamCacheCreateFunction));

    PDResources resources = new PDResources();
    resources.add(image);

    // Act
    String actualToolTipText = (new FontToolTip(resources, "Row Text")).getToolTipText();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualToolTipText);
  }
}
