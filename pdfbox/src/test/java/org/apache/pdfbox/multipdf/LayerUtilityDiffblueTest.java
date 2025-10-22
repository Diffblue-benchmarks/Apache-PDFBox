package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LayerUtilityDiffblueTest {
  /**
   * Test {@link LayerUtility#LayerUtility(PDDocument)}.
   * <p>
   * Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  @DisplayName("Test new LayerUtility(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LayerUtility.<init>(PDDocument)"})
  void testNewLayerUtility() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Test {@link LayerUtility#getDocument()}.
   * <p>
   * Method under test: {@link LayerUtility#getDocument()}
   */
  @Test
  @DisplayName("Test getDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDDocument LayerUtility.getDocument()"})
  void testGetDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, (new LayerUtility(targetDoc)).getDocument());
  }

  /**
   * Test {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}.
   * <p>
   * Method under test: {@link LayerUtility#appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)}
   */
  @Test
  @DisplayName("Test appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup LayerUtility.appendFormAsLayer(PDPage, PDFormXObject, AffineTransform, String)"})
  void testAppendFormAsLayer() throws IOException {
    // Arrange
    LayerUtility layerUtility = new LayerUtility(new PDDocument());
    PDPage targetPage = new PDPage();
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act and Assert
    COSDictionary cOSObject = layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "Layer Name")
        .getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    COSDictionary cOSObject2 = layerUtility.getDocument().getDocumentCatalog().getOCProperties().getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    assertTrue(iteratorResult2.hasNext());
    assertSame(cOSObject, actualNextResult);
    assertSame(cOSObject2, iteratorResult2.next());
  }
}
