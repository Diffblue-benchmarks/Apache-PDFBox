package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDestinationDiffblueTest {
  /**
   * Test {@link PDDestination#create(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDestination#create(COSBase)}
   */
  @Test
  @DisplayName("Test create(COSBase); when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDestination PDDestination.create(COSBase)"})
  void testCreate_whenNull_thenNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(null);
    assertNull(PDDestination.create(null));
  }
}
