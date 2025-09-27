package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.bmp.BMPMetadata;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Node;

class JPEGUtilDiffblueTest {
  /**
   * Test {@link JPEGUtil#updateMetadata(IIOMetadata, int)}.
   *
   * <ul>
   *   <li>Given {@link TIFFFieldNode#TIFFFieldNode(TIFFField)} with field is {@link
   *       TIFFField#TIFFField(TIFFTag, int)}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGUtil#updateMetadata(IIOMetadata, int)}
   */
  @Test
  @DisplayName(
      "Test updateMetadata(IIOMetadata, int); given TIFFFieldNode(TIFFField) with field is TIFFField(TIFFTag, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JPEGUtil.updateMetadata(IIOMetadata, int)"})
  void testUpdateMetadata_givenTIFFFieldNodeWithFieldIsTIFFField() throws IIOInvalidTreeException {
    // Arrange
    BMPMetadata metadata = mock(BMPMetadata.class);
    doNothing().when(metadata).setFromTree(Mockito.<String>any(), Mockito.<Node>any());
    TIFFTag tag = new TIFFTag("javax_imageio_jpeg_image_1.0", TIFFTag.TIFF_SRATIONAL, 500);
    when(metadata.getAsTree(Mockito.<String>any()))
        .thenReturn(new TIFFFieldNode(new TIFFField(tag, 42)));

    // Act
    JPEGUtil.updateMetadata(metadata, 1);

    // Assert
    verify(metadata).getAsTree("javax_imageio_jpeg_image_1.0");
    verify(metadata).setFromTree(eq("javax_imageio_jpeg_image_1.0"), isA(Node.class));
  }

  /**
   * Test {@link JPEGUtil#updateMetadata(IIOMetadata, int)}.
   *
   * <ul>
   *   <li>Then calls {@link TIFFFieldNode#getElementsByTagName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGUtil#updateMetadata(IIOMetadata, int)}
   */
  @Test
  @DisplayName("Test updateMetadata(IIOMetadata, int); then calls getElementsByTagName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JPEGUtil.updateMetadata(IIOMetadata, int)"})
  void testUpdateMetadata_thenCallsGetElementsByTagName() throws IIOInvalidTreeException {
    // Arrange
    TIFFFieldNode tiffFieldNode = mock(TIFFFieldNode.class);
    TIFFTag tag = new TIFFTag("javax_imageio_jpeg_image_1.0", TIFFTag.TIFF_SRATIONAL, 500);
    when(tiffFieldNode.getElementsByTagName(Mockito.<String>any()))
        .thenReturn(new TIFFFieldNode(new TIFFField(tag, 42)));

    BMPMetadata metadata = mock(BMPMetadata.class);
    doNothing().when(metadata).setFromTree(Mockito.<String>any(), Mockito.<Node>any());
    when(metadata.getAsTree(Mockito.<String>any())).thenReturn(tiffFieldNode);

    // Act
    JPEGUtil.updateMetadata(metadata, 1);

    // Assert
    verify(metadata).getAsTree("javax_imageio_jpeg_image_1.0");
    verify(metadata).setFromTree(eq("javax_imageio_jpeg_image_1.0"), isA(Node.class));
    verify(tiffFieldNode).getElementsByTagName("JPEGvariety");
  }

  /**
   * Test {@link JPEGUtil#updateMetadata(IIOMetadata, int)}.
   *
   * <ul>
   *   <li>Then throw {@link IIOInvalidTreeException}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGUtil#updateMetadata(IIOMetadata, int)}
   */
  @Test
  @DisplayName("Test updateMetadata(IIOMetadata, int); then throw IIOInvalidTreeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JPEGUtil.updateMetadata(IIOMetadata, int)"})
  void testUpdateMetadata_thenThrowIIOInvalidTreeException() throws IIOInvalidTreeException {
    // Arrange
    BMPMetadata metadata = mock(BMPMetadata.class);
    IIOInvalidTreeException iioInvalidTreeException =
        new IIOInvalidTreeException("javax_imageio_jpeg_image_1.0", new IIOMetadataNode());
    doThrow(iioInvalidTreeException)
        .when(metadata)
        .setFromTree(Mockito.<String>any(), Mockito.<Node>any());
    TIFFTag tag = new TIFFTag("javax_imageio_jpeg_image_1.0", TIFFTag.TIFF_SRATIONAL, 500);
    when(metadata.getAsTree(Mockito.<String>any()))
        .thenReturn(new TIFFFieldNode(new TIFFField(tag, 42)));

    // Act and Assert
    assertThrows(IIOInvalidTreeException.class, () -> JPEGUtil.updateMetadata(metadata, 1));
    verify(metadata).getAsTree("javax_imageio_jpeg_image_1.0");
    verify(metadata).setFromTree(eq("javax_imageio_jpeg_image_1.0"), isA(Node.class));
  }
}
