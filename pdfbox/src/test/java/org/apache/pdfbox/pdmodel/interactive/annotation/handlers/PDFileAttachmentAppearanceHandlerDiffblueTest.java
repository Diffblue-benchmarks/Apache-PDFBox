package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFileAttachmentAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFileAttachmentAppearanceHandler#PDFileAttachmentAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFileAttachmentAppearanceHandler.<init>(PDAnnotation)",
    "void PDFileAttachmentAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDFileAttachmentAppearanceHandler.generateDownAppearance()",
    "void PDFileAttachmentAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFileAttachmentAppearanceHandler actualPdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(annotation);
    actualPdFileAttachmentAppearanceHandler.generateDownAppearance();
    actualPdFileAttachmentAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdFileAttachmentAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdFileAttachmentAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFileAttachmentAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(new PDAnnotationFileAttachment());

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(
        pdFileAttachmentAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFileAttachmentAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(-8.0f);
    verify(pdRectangle).setUpperRightX(28.0f);
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDRectangle bBox =
        pdFileAttachmentAppearanceHandler
            .getAppearance()
            .getDownAppearance()
            .getAppearanceStream()
            .getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream =
        pdFileAttachmentAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    List<? extends COSBase> toListResult = bBox2.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertEquals(
        toListResult,
        pdFileAttachmentAppearanceHandler
            .getRolloverAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFileAttachmentAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(-8.0f);
    verify(pdRectangle).setUpperRightX(28.0f);
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    Matrix matrix = downAppearance.getAppearanceStream().getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFileAttachmentAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(0.5f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(-8.0f);
    verify(pdRectangle).setUpperRightX(28.0f);
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream =
        pdFileAttachmentAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> extGStateNames = appearanceStream.getResources().getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(812, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 =
        pdFileAttachmentAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(812, appearanceStream2.getStream().getLength());
    assertEquals(812, appearanceStream.getContentStream().getLength());
    assertEquals(812, appearanceStream2.getContentStream().getLength());
    assertSame(extGStateNames, appearanceStream2.getResources().getExtGStateNames());
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFileAttachmentAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler =
        new PDFileAttachmentAppearanceHandler(annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(-8.0f);
    verify(pdRectangle).setUpperRightX(28.0f);
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(804, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 =
        pdFileAttachmentAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(804, appearanceStream2.getStream().getLength());
    assertEquals(804, appearanceStream.getContentStream().getLength());
    assertEquals(804, appearanceStream2.getContentStream().getLength());
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, appearanceStream2.getResources().getExtGStateNames());
  }
}
