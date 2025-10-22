package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StandardProtectionPolicyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StandardProtectionPolicy#StandardProtectionPolicy(String, String, AccessPermission)}
   *   <li>{@link StandardProtectionPolicy#setOwnerPassword(String)}
   *   <li>{@link StandardProtectionPolicy#setPermissions(AccessPermission)}
   *   <li>{@link StandardProtectionPolicy#setUserPassword(String)}
   *   <li>{@link StandardProtectionPolicy#getOwnerPassword()}
   *   <li>{@link StandardProtectionPolicy#getPermissions()}
   *   <li>{@link StandardProtectionPolicy#getUserPassword()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StandardProtectionPolicy.<init>(String, String, AccessPermission)",
      "String StandardProtectionPolicy.getOwnerPassword()",
      "AccessPermission StandardProtectionPolicy.getPermissions()", "String StandardProtectionPolicy.getUserPassword()",
      "void StandardProtectionPolicy.setOwnerPassword(String)",
      "void StandardProtectionPolicy.setPermissions(AccessPermission)",
      "void StandardProtectionPolicy.setUserPassword(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    StandardProtectionPolicy actualStandardProtectionPolicy = new StandardProtectionPolicy("iloveyou", "iloveyou",
        AccessPermission.getOwnerAccessPermission());
    actualStandardProtectionPolicy.setOwnerPassword("iloveyou");
    AccessPermission permissions = AccessPermission.getOwnerAccessPermission();
    actualStandardProtectionPolicy.setPermissions(permissions);
    actualStandardProtectionPolicy.setUserPassword("iloveyou");
    String actualOwnerPassword = actualStandardProtectionPolicy.getOwnerPassword();
    AccessPermission actualPermissions = actualStandardProtectionPolicy.getPermissions();

    // Assert
    assertEquals("iloveyou", actualOwnerPassword);
    assertEquals("iloveyou", actualStandardProtectionPolicy.getUserPassword());
    assertFalse(actualStandardProtectionPolicy.isPreferAES());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualStandardProtectionPolicy.getEncryptionKeyLength());
    assertSame(permissions, actualPermissions);
  }
}
