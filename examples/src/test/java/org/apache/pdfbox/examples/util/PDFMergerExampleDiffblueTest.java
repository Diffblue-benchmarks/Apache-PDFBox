package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.io.RandomAccessRead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFMergerExampleDiffblueTest {
  /**
   * Test {@link PDFMergerExample#merge(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerExample#merge(List)}
   */
  @Test
  @DisplayName(
      "Test merge(List); given ArrayList(); when ArrayList() addAll ArrayList(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDFMergerExample.merge(List)"})
  void testMerge_givenArrayList_whenArrayListAddAllArrayList_thenReturnReadIsMinusOne()
      throws IOException {
    // Arrange
    PDFMergerExample pdfMergerExample = new PDFMergerExample();

    ArrayList<RandomAccessRead> sources = new ArrayList<>();
    sources.addAll(new ArrayList<>());

    // Act and Assert
    int actualReadResult = pdfMergerExample.merge(sources).read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link PDFMergerExample#merge(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDFMergerExample#merge(List)}
   */
  @Test
  @DisplayName("Test merge(List); when ArrayList(); then return read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream PDFMergerExample.merge(List)"})
  void testMerge_whenArrayList_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    PDFMergerExample pdfMergerExample = new PDFMergerExample();

    // Act and Assert
    int actualReadResult = pdfMergerExample.merge(new ArrayList<>()).read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }
}
