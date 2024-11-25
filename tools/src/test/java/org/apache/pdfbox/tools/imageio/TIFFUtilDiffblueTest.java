package org.apache.pdfbox.tools.imageio;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.github.jaiimageio.impl.plugins.raw.RawImageWriteParam;
import java.awt.image.BufferedImage;
import javax.imageio.ImageWriteParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TIFFUtilDiffblueTest {
  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   * <ul>
   *   <li>Then calls {@link ImageWriteParam#setCompressionType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName("Test setCompressionType(ImageWriteParam, BufferedImage); then calls setCompressionType(String)")
  void testSetCompressionType_thenCallsSetCompressionType() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, 1));

    // Assert that nothing has changed
    verify(param).setCompressionType(eq("LZW"));
  }

  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and {@link BufferedImage#TYPE_BYTE_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName("Test setCompressionType(ImageWriteParam, BufferedImage); when BufferedImage(int, int, int) with one and one and TYPE_BYTE_BINARY")
  void testSetCompressionType_whenBufferedImageWithOneAndOneAndType_byte_binary() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert that nothing has changed
    verify(param).setCompressionType(eq("CCITT T.6"));
  }
}
