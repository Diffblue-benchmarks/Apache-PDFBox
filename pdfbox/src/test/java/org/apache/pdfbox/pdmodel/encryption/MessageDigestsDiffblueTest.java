package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.security.MessageDigest;
import java.security.Provider;
import org.junit.jupiter.api.Test;

class MessageDigestsDiffblueTest {
  /**
   * Method under test: {@link MessageDigests#getMD5()}
   */
  @Test
  void testGetMD5() {
    // Arrange and Act
    MessageDigest actualMD5 = MessageDigests.getMD5();

    // Assert
    Provider provider = actualMD5.getProvider();
    assertEquals(152, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.AlgorithmParameterGenerator.1.2.840.10040.4.1"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("MD5", actualMD5.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals(Short.SIZE, actualMD5.getDigestLength());
  }

  /**
   * Method under test: {@link MessageDigests#getSHA1()}
   */
  @Test
  void testGetSHA1() {
    // Arrange and Act
    MessageDigest actualSHA1 = MessageDigests.getSHA1();

    // Assert
    Provider provider = actualSHA1.getProvider();
    assertEquals(152, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.AlgorithmParameterGenerator.1.2.840.10040.4.1"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-1", actualSHA1.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals(20, actualSHA1.getDigestLength());
  }

  /**
   * Method under test: {@link MessageDigests#getSHA256()}
   */
  @Test
  void testGetSHA256() {
    // Arrange and Act
    MessageDigest actualSHA256 = MessageDigests.getSHA256();

    // Assert
    Provider provider = actualSHA256.getProvider();
    assertEquals(152, provider.size());
    assertEquals("2048", provider.get("Signature.SHA256withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.AlgorithmParameterGenerator.1.2.840.10040.4.1"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-256", actualSHA256.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("SHA224withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.1"));
    assertEquals("SHA256withDSA", provider.get("Alg.Alias.Signature.2.16.840.1.101.3.4.3.2"));
    assertEquals(Integer.SIZE, actualSHA256.getDigestLength());
  }
}
