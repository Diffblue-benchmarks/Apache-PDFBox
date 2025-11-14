package org.apache.pdfbox.pdmodel.graphics.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTransparencyGroupDiffblueTest {
  /**
   * Test {@link PDTransparencyGroup#PDTransparencyGroup(PDStream)}.
   *
   * <ul>
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroup#PDTransparencyGroup(PDStream)}
   */
  @Test
  @DisplayName("Test new PDTransparencyGroup(PDStream); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransparencyGroup.<init>(PDStream)"})
  void testNewPDTransparencyGroup_thenReturnResourcesIsNull() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDTransparencyGroup actualPdTransparencyGroup = new PDTransparencyGroup(stream);

    // Assert
    assertNull(actualPdTransparencyGroup.getResources());
    assertNull(actualPdTransparencyGroup.getBBox());
    assertNull(actualPdTransparencyGroup.getOptionalContent());
    assertNull(actualPdTransparencyGroup.getGroup());
    assertEquals(-1, actualPdTransparencyGroup.getStructParents());
    assertEquals(1, actualPdTransparencyGroup.getFormType());
    assertSame(stream, actualPdTransparencyGroup.getStream());
  }

  /**
   * Test {@link PDTransparencyGroup#PDTransparencyGroup(COSStream, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroup#PDTransparencyGroup(COSStream, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDTransparencyGroup(COSStream, ResourceCache); when COSStream(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransparencyGroup.<init>(COSStream, ResourceCache)"})
  void testNewPDTransparencyGroup_whenCOSStream_thenReturnResourcesIsNull() {
    // Arrange
    COSStream stream = new COSStream();

    // Act
    PDTransparencyGroup actualPdTransparencyGroup =
        new PDTransparencyGroup(stream, new DefaultResourceCache());

    // Assert
    assertNull(actualPdTransparencyGroup.getResources());
    assertNull(actualPdTransparencyGroup.getBBox());
    assertNull(actualPdTransparencyGroup.getOptionalContent());
    assertNull(actualPdTransparencyGroup.getGroup());
    assertEquals(-1, actualPdTransparencyGroup.getStructParents());
    assertEquals(1, actualPdTransparencyGroup.getFormType());
    assertEquals(3, stream.size());
    assertSame(stream, actualPdTransparencyGroup.getCOSObject());
  }

  /**
   * Test {@link PDTransparencyGroup#PDTransparencyGroup(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransparencyGroup#PDTransparencyGroup(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDTransparencyGroup(PDDocument); when PDDocument(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransparencyGroup.<init>(PDDocument)"})
  void testNewPDTransparencyGroup_whenPDDocument_thenReturnResourcesIsNull() {
    // Arrange and Act
    PDTransparencyGroup actualPdTransparencyGroup = new PDTransparencyGroup(new PDDocument());

    // Assert
    assertNull(actualPdTransparencyGroup.getResources());
    assertNull(actualPdTransparencyGroup.getBBox());
    assertNull(actualPdTransparencyGroup.getOptionalContent());
    assertNull(actualPdTransparencyGroup.getGroup());
    assertEquals(-1, actualPdTransparencyGroup.getStructParents());
    assertEquals(1, actualPdTransparencyGroup.getFormType());
  }
}
