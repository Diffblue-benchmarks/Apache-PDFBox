package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PublicKeyRecipientDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PublicKeyRecipient}
   *   <li>{@link PublicKeyRecipient#setPermission(AccessPermission)}
   *   <li>{@link PublicKeyRecipient#getPermission()}
   *   <li>{@link PublicKeyRecipient#getX509()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PublicKeyRecipient.<init>()", "AccessPermission PublicKeyRecipient.getPermission()",
      "java.security.cert.X509Certificate PublicKeyRecipient.getX509()",
      "void PublicKeyRecipient.setPermission(AccessPermission)",
      "void PublicKeyRecipient.setX509(java.security.cert.X509Certificate)"})
  void testGettersAndSetters() {
    // Arrange and Act
    PublicKeyRecipient actualPublicKeyRecipient = new PublicKeyRecipient();
    AccessPermission permissions = AccessPermission.getOwnerAccessPermission();
    actualPublicKeyRecipient.setPermission(permissions);
    AccessPermission actualPermission = actualPublicKeyRecipient.getPermission();

    // Assert
    assertNull(actualPublicKeyRecipient.getX509());
    assertSame(permissions, actualPermission);
  }
}
