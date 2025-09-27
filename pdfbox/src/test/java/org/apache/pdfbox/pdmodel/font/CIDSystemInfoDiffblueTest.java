package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CIDSystemInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CIDSystemInfo#CIDSystemInfo(String, String, int)}
   *   <li>{@link CIDSystemInfo#toString()}
   *   <li>{@link CIDSystemInfo#getOrdering()}
   *   <li>{@link CIDSystemInfo#getRegistry()}
   *   <li>{@link CIDSystemInfo#getSupplement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CIDSystemInfo.<init>(String, String, int)",
    "String CIDSystemInfo.getOrdering()",
    "String CIDSystemInfo.getRegistry()",
    "int CIDSystemInfo.getSupplement()",
    "String CIDSystemInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CIDSystemInfo actualCidSystemInfo = new CIDSystemInfo("Registry", "Ordering", 1);
    String actualToStringResult = actualCidSystemInfo.toString();
    String actualOrdering = actualCidSystemInfo.getOrdering();
    String actualRegistry = actualCidSystemInfo.getRegistry();

    // Assert
    assertEquals("Ordering", actualOrdering);
    assertEquals("Registry", actualRegistry);
    assertEquals("Registry-Ordering-1", actualToStringResult);
    assertEquals(1, actualCidSystemInfo.getSupplement());
  }
}
