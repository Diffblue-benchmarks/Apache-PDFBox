package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFormContentStreamDiffblueTest {
  /**
   * Test {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}.
   *
   * <p>Method under test: {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}
   */
  @Test
  @DisplayName("Test new PDFormContentStream(PDFormXObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormContentStream.<init>(PDFormXObject)"})
  void testNewPDFormContentStream() throws IOException {
    // Arrange
    PDFormXObject form = new PDFormXObject(new COSStream());

    // Act
    PDFormContentStream actualPdFormContentStream = new PDFormContentStream(form);

    // Assert
    assertNull(actualPdFormContentStream.document);
    assertNull(actualPdFormContentStream.resources);
    assertFalse(actualPdFormContentStream.inTextMode);
    assertTrue(actualPdFormContentStream.fontStack.isEmpty());
    assertTrue(actualPdFormContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdFormContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(form.getCOSObject().hasData());
  }

  /**
   * Test {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}.
   *
   * <p>Method under test: {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}
   */
  @Test
  @DisplayName("Test new PDFormContentStream(PDFormXObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormContentStream.<init>(PDFormXObject)"})
  void testNewPDFormContentStream2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata stream = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    PDFormXObject form = new PDFormXObject(stream);

    // Act
    PDFormContentStream actualPdFormContentStream = new PDFormContentStream(form);

    // Assert
    assertNull(actualPdFormContentStream.document);
    assertNull(actualPdFormContentStream.resources);
    assertFalse(actualPdFormContentStream.inTextMode);
    assertTrue(actualPdFormContentStream.fontStack.isEmpty());
    assertTrue(actualPdFormContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdFormContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(form.getCOSObject().hasData());
  }

  /**
   * Test {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFormContentStream#PDFormContentStream(PDFormXObject)}
   */
  @Test
  @DisplayName("Test new PDFormContentStream(PDFormXObject); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFormContentStream.<init>(PDFormXObject)"})
  void testNewPDFormContentStream_givenArrayList() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata stream = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    stream.setFilters(new ArrayList<>());
    PDFormXObject form = new PDFormXObject(stream);

    // Act
    PDFormContentStream actualPdFormContentStream = new PDFormContentStream(form);

    // Assert
    assertNull(actualPdFormContentStream.document);
    assertNull(actualPdFormContentStream.resources);
    assertFalse(actualPdFormContentStream.inTextMode);
    assertTrue(actualPdFormContentStream.fontStack.isEmpty());
    assertTrue(actualPdFormContentStream.nonStrokingColorSpaceStack.isEmpty());
    assertTrue(actualPdFormContentStream.strokingColorSpaceStack.isEmpty());
    assertTrue(form.getCOSObject().hasData());
  }
}
