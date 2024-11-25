package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
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
  void testGettersAndSetters() {
    // Arrange and Act
    PublicKeyRecipient actualPublicKeyRecipient = new PublicKeyRecipient();
    AccessPermission permissions = AccessPermission.getOwnerAccessPermission();
    actualPublicKeyRecipient.setPermission(permissions);
    AccessPermission actualPermission = actualPublicKeyRecipient.getPermission();
    actualPublicKeyRecipient.getX509();

    // Assert that nothing has changed
    assertSame(permissions, actualPermission);
  }
}
