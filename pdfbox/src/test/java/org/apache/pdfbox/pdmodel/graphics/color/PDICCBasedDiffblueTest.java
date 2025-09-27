package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDICCBasedDiffblueTest {
  /**
   * Test {@link PDICCBased#PDICCBased(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#PDICCBased(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDICCBased(PDDocument); when PDDocument(); then COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDICCBased.<init>(PDDocument)"})
  void testNewPDICCBased_whenPDDocument_thenCOSObjectReturnCOSArray() throws IOException {
    // Arrange and Act
    PDICCBased actualPdiccBased = new PDICCBased(new PDDocument());

    // Assert
    COSBase cOSObject = actualPdiccBased.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals("ICCBased", actualPdiccBased.getName());
    PDStream pDStream = actualPdiccBased.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(actualPdiccBased.getMetadata());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertNull(actualPdiccBased.getInitialColor());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(-1, actualPdiccBased.getNumberOfComponents());
    assertEquals(0, pDStream.getLength());
    assertEquals(2, ((COSArray) cOSObject).toList().size());
    assertFalse(actualPdiccBased.isSRGB());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Test {@link PDICCBased#create(COSArray, PDResources)} with {@code iccArray}, {@code resources}.
   *
   * <ul>
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  @DisplayName(
      "Test create(COSArray, PDResources) with 'iccArray', 'resources'; then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDICCBased PDICCBased.create(COSArray, PDResources)"})
  void testCreateWithIccArrayResources_thenCallsGetCOSObject() throws IOException {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    COSArray iccArray = new COSArray(cosObjectables);
    iccArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, null));
    verify(cosObjectable).getCOSObject();
  }

  /**
   * Test {@link PDICCBased#create(COSArray, PDResources)} with {@code iccArray}, {@code resources}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDICCBased#create(COSArray, PDResources)}
   */
  @Test
  @DisplayName("Test create(COSArray, PDResources) with 'iccArray', 'resources'; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDICCBased PDICCBased.create(COSArray, PDResources)"})
  void testCreateWithIccArrayResources_whenCOSArray() throws IOException {
    // Arrange
    COSArray iccArray = new COSArray();

    // Act and Assert
    assertThrows(IOException.class, () -> PDICCBased.create(iccArray, new PDResources()));
  }
}
