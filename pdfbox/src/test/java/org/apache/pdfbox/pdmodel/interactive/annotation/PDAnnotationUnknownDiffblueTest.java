package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationUnknownDiffblueTest {
  /**
   * Test {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationUnknown(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationUnknown.<init>(COSDictionary)"})
  void testNewPDAnnotationUnknown_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act
    PDAnnotationUnknown actualPdAnnotationUnknown = new PDAnnotationUnknown(dic);

    // Assert
    assertEquals(1, dic.size());
    List<? extends COSBase> toListResult = actualPdAnnotationUnknown.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, actualPdAnnotationUnknown.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationUnknown#PDAnnotationUnknown(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationUnknown(COSDictionary); when COSStream(); then COSStream() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationUnknown.<init>(COSDictionary)"})
  void testNewPDAnnotationUnknown_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream dic = new COSStream();

    // Act
    PDAnnotationUnknown actualPdAnnotationUnknown = new PDAnnotationUnknown(dic);

    // Assert
    assertEquals(2, dic.size());
    List<? extends COSBase> toListResult = actualPdAnnotationUnknown.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, actualPdAnnotationUnknown.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }
}
