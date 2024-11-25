package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProtectionPolicyDiffblueTest {
  /**
   * Test {@link ProtectionPolicy#setEncryptionKeyLength(int)}.
   * <p>
   * Method under test: {@link ProtectionPolicy#setEncryptionKeyLength(int)}
   */
  @Test
  @DisplayName("Test setEncryptionKeyLength(int)")
  void testSetEncryptionKeyLength() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    publicKeyProtectionPolicy.setEncryptionKeyLength(PDEncryption.DEFAULT_LENGTH);

    // Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, publicKeyProtectionPolicy.getEncryptionKeyLength());
  }

  /**
   * Test {@link ProtectionPolicy#setEncryptionKeyLength(int)}.
   * <p>
   * Method under test: {@link ProtectionPolicy#setEncryptionKeyLength(int)}
   */
  @Test
  @DisplayName("Test setEncryptionKeyLength(int)")
  void testSetEncryptionKeyLength2() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    publicKeyProtectionPolicy.setEncryptionKeyLength(128);

    // Assert
    assertEquals(128, publicKeyProtectionPolicy.getEncryptionKeyLength());
  }

  /**
   * Test {@link ProtectionPolicy#setEncryptionKeyLength(int)}.
   * <p>
   * Method under test: {@link ProtectionPolicy#setEncryptionKeyLength(int)}
   */
  @Test
  @DisplayName("Test setEncryptionKeyLength(int)")
  void testSetEncryptionKeyLength3() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    publicKeyProtectionPolicy.setEncryptionKeyLength(256);

    // Assert
    assertEquals(256, publicKeyProtectionPolicy.getEncryptionKeyLength());
  }

  /**
   * Test {@link ProtectionPolicy#setEncryptionKeyLength(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtectionPolicy#setEncryptionKeyLength(int)}
   */
  @Test
  @DisplayName("Test setEncryptionKeyLength(int); when one; then throw IllegalArgumentException")
  void testSetEncryptionKeyLength_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PublicKeyProtectionPolicy()).setEncryptionKeyLength(1));
  }

  /**
   * Test {@link ProtectionPolicy#getEncryptionKeyLength()}.
   * <p>
   * Method under test: {@link ProtectionPolicy#getEncryptionKeyLength()}
   */
  @Test
  @DisplayName("Test getEncryptionKeyLength()")
  void testGetEncryptionKeyLength() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PublicKeyProtectionPolicy()).getEncryptionKeyLength());
  }

  /**
   * Test {@link ProtectionPolicy#isPreferAES()}.
   * <ul>
   *   <li>Given {@link PublicKeyProtectionPolicy} (default constructor) PreferAES
   * is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtectionPolicy#isPreferAES()}
   */
  @Test
  @DisplayName("Test isPreferAES(); given PublicKeyProtectionPolicy (default constructor) PreferAES is 'true'; then return 'true'")
  void testIsPreferAES_givenPublicKeyProtectionPolicyPreferAESIsTrue_thenReturnTrue() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();
    publicKeyProtectionPolicy.setPreferAES(true);

    // Act and Assert
    assertTrue(publicKeyProtectionPolicy.isPreferAES());
  }

  /**
   * Test {@link ProtectionPolicy#isPreferAES()}.
   * <ul>
   *   <li>Given {@link PublicKeyProtectionPolicy} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtectionPolicy#isPreferAES()}
   */
  @Test
  @DisplayName("Test isPreferAES(); given PublicKeyProtectionPolicy (default constructor); then return 'false'")
  void testIsPreferAES_givenPublicKeyProtectionPolicy_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PublicKeyProtectionPolicy()).isPreferAES());
  }

  /**
   * Test {@link ProtectionPolicy#setPreferAES(boolean)}.
   * <p>
   * Method under test: {@link ProtectionPolicy#setPreferAES(boolean)}
   */
  @Test
  @DisplayName("Test setPreferAES(boolean)")
  void testSetPreferAES() {
    // Arrange
    PublicKeyProtectionPolicy publicKeyProtectionPolicy = new PublicKeyProtectionPolicy();

    // Act
    publicKeyProtectionPolicy.setPreferAES(true);

    // Assert
    assertTrue(publicKeyProtectionPolicy.isPreferAES());
  }
}
