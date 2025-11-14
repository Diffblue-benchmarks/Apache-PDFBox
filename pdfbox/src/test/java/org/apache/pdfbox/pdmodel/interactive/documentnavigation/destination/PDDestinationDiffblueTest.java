package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDestinationDiffblueTest {
  /**
   * Test {@link PDDestination#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link PDNamedDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PDDestination#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when A; then return PDNamedDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDestination PDDestination.create(COSBase)"})
  void testCreate_whenA_thenReturnPDNamedDestination() throws IOException {
    // Arrange and Act
    PDDestination actualCreateResult = PDDestination.create(COSName.A);
    COSBase actualCOSObject = actualCreateResult.getCOSObject();

    // Assert
    assertTrue(actualCreateResult instanceof PDNamedDestination);
    assertEquals("A", ((PDNamedDestination) actualCreateResult).getNamedDestination());
    COSName cosName = ((COSName) actualCOSObject).A;
    assertSame(cosName, actualCreateResult.getCOSObject());
    assertSame(cosName, actualCOSObject);
  }
}
