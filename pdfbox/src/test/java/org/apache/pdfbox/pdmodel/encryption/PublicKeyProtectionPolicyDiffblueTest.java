package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PublicKeyProtectionPolicyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PublicKeyProtectionPolicy}
   *   <li>{@link PublicKeyProtectionPolicy#getDecryptionCertificate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PublicKeyProtectionPolicy.<init>()",
    "java.security.cert.X509Certificate PublicKeyProtectionPolicy.getDecryptionCertificate()",
    "void PublicKeyProtectionPolicy.setDecryptionCertificate(java.security.cert.X509Certificate)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PublicKeyProtectionPolicy actualPublicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Assert
    assertNull(actualPublicKeyProtectionPolicy.getDecryptionCertificate());
    assertFalse(actualPublicKeyProtectionPolicy.isPreferAES());
    assertEquals(
        PDEncryption.DEFAULT_LENGTH, actualPublicKeyProtectionPolicy.getEncryptionKeyLength());
  }

  /**
   * Test {@link PublicKeyProtectionPolicy#addRecipient(PublicKeyRecipient)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link PublicKeyProtectionPolicy} (default constructor) NumberOfRecipients is one.
   * </ul>
   *
   * <p>Method under test: {@link PublicKeyProtectionPolicy#addRecipient(PublicKeyRecipient)}
   */
  @Test
  @DisplayName(
      "Test addRecipient(PublicKeyRecipient); given 'null'; then PublicKeyProtectionPolicy (default constructor) NumberOfRecipients is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PublicKeyProtectionPolicy.addRecipient(PublicKeyRecipient)"})
  void testAddRecipient_givenNull_thenPublicKeyProtectionPolicyNumberOfRecipientsIsOne() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    PublicKeyRecipient recipient = new PublicKeyRecipient();
    recipient.setPermission(AccessPermission.getOwnerAccessPermission());
    recipient.setX509(null);

    // Act
    publicKeyProtectionPolicy.addRecipient(recipient);

    // Assert
    assertEquals(1, publicKeyProtectionPolicy.getNumberOfRecipients());
    Iterator<PublicKeyRecipient> recipientsIterator =
        publicKeyProtectionPolicy.getRecipientsIterator();
    PublicKeyRecipient actualNextResult = recipientsIterator.next();
    assertFalse(recipientsIterator.hasNext());
    assertSame(recipient, actualNextResult);
  }

  /**
   * Test {@link PublicKeyProtectionPolicy#removeRecipient(PublicKeyRecipient)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PublicKeyRecipient} (default constructor) X509 is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PublicKeyProtectionPolicy#removeRecipient(PublicKeyRecipient)}
   */
  @Test
  @DisplayName(
      "Test removeRecipient(PublicKeyRecipient); given 'null'; when PublicKeyRecipient (default constructor) X509 is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PublicKeyProtectionPolicy.removeRecipient(PublicKeyRecipient)"})
  void testRemoveRecipient_givenNull_whenPublicKeyRecipientX509IsNull_thenReturnFalse() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    PublicKeyRecipient recipient = new PublicKeyRecipient();
    recipient.setPermission(AccessPermission.getOwnerAccessPermission());
    recipient.setX509(null);

    // Act and Assert
    assertFalse(publicKeyProtectionPolicy.removeRecipient(recipient));
  }

  /**
   * Test {@link PublicKeyProtectionPolicy#getRecipientsIterator()}.
   *
   * <p>Method under test: {@link PublicKeyProtectionPolicy#getRecipientsIterator()}
   */
  @Test
  @DisplayName("Test getRecipientsIterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PublicKeyProtectionPolicy.getRecipientsIterator()"})
  void testGetRecipientsIterator() {
    // Arrange, Act and Assert
    assertFalse(new PublicKeyProtectionPolicy().getRecipientsIterator().hasNext());
  }

  /**
   * Test {@link PublicKeyProtectionPolicy#getNumberOfRecipients()}.
   *
   * <p>Method under test: {@link PublicKeyProtectionPolicy#getNumberOfRecipients()}
   */
  @Test
  @DisplayName("Test getNumberOfRecipients()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PublicKeyProtectionPolicy.getNumberOfRecipients()"})
  void testGetNumberOfRecipients() {
    // Arrange, Act and Assert
    assertEquals(0, new PublicKeyProtectionPolicy().getNumberOfRecipients());
  }
}
