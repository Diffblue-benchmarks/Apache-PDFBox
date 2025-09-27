package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionTypeIdentity;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SoftMaskDiffblueTest {
  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName("Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();
    PDColor backdropColor =
        new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, backdropColor, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName("Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask2() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();
    PDColor backdropColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, new PDCalGray());

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, backdropColor, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName("Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask3() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();
    PDColor backdropColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, new PDCalRGB());

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, backdropColor, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <ul>
   *   <li>Given {@link Matrix#Matrix()}.
   *   <li>When {@link PDCalRGB#PDCalRGB()} Matrix is {@link Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName(
      "Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction); given Matrix(); when PDCalRGB() Matrix is Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask_givenMatrix_whenPDCalRGBMatrixIsMatrix() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();

    PDCalRGB colorSpace = new PDCalRGB();
    colorSpace.setMatrix(new Matrix());
    PDColor backdropColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, colorSpace);

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, backdropColor, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <ul>
   *   <li>Then return Transparency is three.
   * </ul>
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName(
      "Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction); then return Transparency is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask_thenReturnTransparencyIsThree() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, null, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Test {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}.
   *
   * <ul>
   *   <li>When {@link PDFunctionTypeIdentity#PDFunctionTypeIdentity(COSBase)} with function is
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor,
   * PDFunction)}
   */
  @Test
  @DisplayName(
      "Test new SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction); when PDFunctionTypeIdentity(COSBase) with function is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SoftMask.<init>(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)"
  })
  void testNewSoftMask_whenPDFunctionTypeIdentityWithFunctionIsFalse() {
    // Arrange
    BufferedImage mask = new BufferedImage(1, 1, 1);
    Double bboxDevice = new Double();

    // Act
    SoftMask actualSoftMask =
        new SoftMask(null, mask, bboxDevice, null, new PDFunctionTypeIdentity(COSBoolean.FALSE));

    // Assert
    assertEquals(3, actualSoftMask.getTransparency());
  }
}
