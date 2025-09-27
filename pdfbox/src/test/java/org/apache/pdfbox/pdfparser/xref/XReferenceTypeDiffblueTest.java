package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XReferenceTypeDiffblueTest {
  /**
   * Test {@link XReferenceType#getNumericValue()}.
   *
   * <p>Method under test: {@link XReferenceType#getNumericValue()}
   */
  @Test
  @DisplayName("Test getNumericValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int XReferenceType.getNumericValue()"})
  void testGetNumericValue() {
    // Arrange, Act and Assert
    assertEquals(0, XReferenceType.valueOf("FREE").getNumericValue());
  }
}
