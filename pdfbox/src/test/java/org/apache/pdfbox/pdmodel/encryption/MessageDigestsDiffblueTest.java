package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.security.MessageDigest;
import java.security.Provider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageDigestsDiffblueTest {
  /**
   * Test {@link MessageDigests#getMD5()}.
   * <p>
   * Method under test: {@link MessageDigests#getMD5()}
   */
  @Test
  @DisplayName("Test getMD5()")
  void testGetMD5() {
    // Arrange and Act
    MessageDigest actualMD5 = MessageDigests.getMD5();

    // Assert
    Provider provider = actualMD5.getProvider();
    assertEquals(188, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("MD5", actualMD5.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("sun.security.provider.DSA$SHA3_224withDSA", provider.get("Signature.SHA3-224withDSA"));
    assertEquals(Short.SIZE, actualMD5.getDigestLength());
  }

  /**
   * Test {@link MessageDigests#getSHA1()}.
   * <p>
   * Method under test: {@link MessageDigests#getSHA1()}
   */
  @Test
  @DisplayName("Test getSHA1()")
  void testGetSHA1() {
    // Arrange and Act
    MessageDigest actualSHA1 = MessageDigests.getSHA1();

    // Assert
    Provider provider = actualSHA1.getProvider();
    assertEquals(188, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("SHA-1", actualSHA1.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("sun.security.provider.DSA$SHA3_224withDSA", provider.get("Signature.SHA3-224withDSA"));
    assertEquals(20, actualSHA1.getDigestLength());
  }

  /**
   * Test {@link MessageDigests#getSHA256()}.
   * <p>
   * Method under test: {@link MessageDigests#getSHA256()}
   */
  @Test
  @DisplayName("Test getSHA256()")
  void testGetSHA256() {
    // Arrange and Act
    MessageDigest actualSHA256 = MessageDigests.getSHA256();

    // Assert
    Provider provider = actualSHA256.getProvider();
    assertEquals(188, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("SHA-256", actualSHA256.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals("sun.security.provider.DSA$SHA3_224withDSA", provider.get("Signature.SHA3-224withDSA"));
    assertEquals(Integer.SIZE, actualSHA256.getDigestLength());
  }
}
