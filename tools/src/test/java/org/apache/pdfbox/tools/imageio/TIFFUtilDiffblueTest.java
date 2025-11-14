package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.raw.RawImageWriteParam;
import com.github.jaiimageio.impl.plugins.tiff.TIFFIFD;
import com.github.jaiimageio.impl.plugins.tiff.TIFFImageMetadata;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TIFFUtilDiffblueTest {
  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   *
   * <ul>
   *   <li>Then calls {@link RawImageWriteParam#setCompressionType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test setCompressionType(ImageWriteParam, BufferedImage); then calls setCompressionType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TIFFUtil.setCompressionType(ImageWriteParam, BufferedImage)"})
  void testSetCompressionType_thenCallsSetCompressionType() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, 1));

    // Assert
    verify(param).setCompressionType("LZW");
  }

  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   *
   * <ul>
   *   <li>Then calls {@link RawImageWriteParam#setCompressionType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test setCompressionType(ImageWriteParam, BufferedImage); then calls setCompressionType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TIFFUtil.setCompressionType(ImageWriteParam, BufferedImage)"})
  void testSetCompressionType_thenCallsSetCompressionType2() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(param).setCompressionType("CCITT T.6");
  }

  /**
   * Test {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}.
   *
   * <p>Method under test: {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}
   */
  @Test
  @DisplayName("Test updateMetadata(IIOMetadata, BufferedImage, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TIFFUtil.updateMetadata(IIOMetadata, BufferedImage, int)"})
  void testUpdateMetadata() throws IIOInvalidTreeException {
    // Arrange
    TIFFImageMetadata metadata = new TIFFImageMetadata(new TIFFIFD(new ArrayList<>()));

    // Act
    TIFFUtil.updateMetadata(metadata, new BufferedImage(1, 1, 1), 1);

    // Assert
    IIOMetadataNode standardChromaNode = metadata.getStandardChromaNode();
    assertNull(standardChromaNode.getFirstChild());
    assertNull(standardChromaNode.getLastChild());
    assertEquals(0, standardChromaNode.getLength());
    assertEquals(3, metadata.getStandardDataNode().getLength());
    TIFFIFD rootIFD = metadata.getRootIFD();
    assertEquals(5, rootIFD.getNumTIFFFields());
    assertEquals(5, rootIFD.getTIFFFields().length);
    assertFalse(standardChromaNode.hasChildNodes());
  }

  /**
   * Test {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}.
   *
   * <p>Method under test: {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}
   */
  @Test
  @DisplayName("Test updateMetadata(IIOMetadata, BufferedImage, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TIFFUtil.updateMetadata(IIOMetadata, BufferedImage, int)"})
  void testUpdateMetadata2() throws IIOInvalidTreeException {
    // Arrange
    TIFFImageMetadata metadata = new TIFFImageMetadata(new TIFFIFD(new ArrayList<>()));

    // Act
    TIFFUtil.updateMetadata(metadata, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY), 1);

    // Assert
    IIOMetadataNode standardChromaNode = metadata.getStandardChromaNode();
    assertTrue(standardChromaNode.getFirstChild() instanceof IIOMetadataNode);
    assertTrue(standardChromaNode.getLastChild() instanceof IIOMetadataNode);
    assertEquals(2, standardChromaNode.getLength());
    assertEquals(4, metadata.getStandardDataNode().getLength());
    TIFFIFD rootIFD = metadata.getRootIFD();
    assertEquals(6, rootIFD.getNumTIFFFields());
    assertEquals(6, rootIFD.getTIFFFields().length);
    assertTrue(standardChromaNode.hasChildNodes());
  }
}
