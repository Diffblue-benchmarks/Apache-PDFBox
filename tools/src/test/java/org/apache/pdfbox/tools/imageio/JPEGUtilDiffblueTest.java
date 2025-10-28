package org.apache.pdfbox.tools.imageio;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.jaiimageio.impl.plugins.bmp.BMPMetadata;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Node;

class JPEGUtilDiffblueTest {
  /**
   * Method under test: {@link JPEGUtil#updateMetadata(IIOMetadata, int)}
   */
  @Test
  void testUpdateMetadata() throws IIOInvalidTreeException {
    // Arrange
    BMPMetadata metadata = mock(BMPMetadata.class);
    doNothing().when(metadata).setFromTree(Mockito.<String>any(), Mockito.<Node>any());
    when(metadata.getAsTree(Mockito.<String>any())).thenReturn(new IIOMetadataNode("foo"));

    // Act
    JPEGUtil.updateMetadata(metadata, 1);

    // Assert that nothing has changed
    verify(metadata).getAsTree(eq("javax_imageio_jpeg_image_1.0"));
    verify(metadata).setFromTree(eq("javax_imageio_jpeg_image_1.0"), isA(Node.class));
  }

  /**
   * Method under test: {@link JPEGUtil#updateMetadata(IIOMetadata, int)}
   */
  @Test
  void testUpdateMetadata2() throws IIOInvalidTreeException {
    // Arrange
    BMPMetadata metadata = mock(BMPMetadata.class);
    doNothing().when(metadata).setFromTree(Mockito.<String>any(), Mockito.<Node>any());
    when(metadata.getAsTree(Mockito.<String>any())).thenReturn(new IIOMetadataNode("JPEGvariety"));

    // Act
    JPEGUtil.updateMetadata(metadata, 1);

    // Assert that nothing has changed
    verify(metadata).getAsTree(eq("javax_imageio_jpeg_image_1.0"));
    verify(metadata).setFromTree(eq("javax_imageio_jpeg_image_1.0"), isA(Node.class));
  }
}
