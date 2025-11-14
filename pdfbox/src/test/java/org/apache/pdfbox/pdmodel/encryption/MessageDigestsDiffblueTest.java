package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.security.MessageDigest;
import java.security.Provider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageDigestsDiffblueTest {
  /**
   * Test {@link MessageDigests#getMD5()}.
   *
   * <p>Method under test: {@link MessageDigests#getMD5()}
   */
  @Test
  @DisplayName("Test getMD5()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageDigest MessageDigests.getMD5()"})
  void testGetMD5() {
    // Arrange and Act
    MessageDigest actualMD5 = MessageDigests.getMD5();

    // Assert
    Provider provider = actualMD5.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("MD5", actualMD5.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(Short.SIZE, actualMD5.getDigestLength());
  }

  /**
   * Test {@link MessageDigests#getSHA1()}.
   *
   * <p>Method under test: {@link MessageDigests#getSHA1()}
   */
  @Test
  @DisplayName("Test getSHA1()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageDigest MessageDigests.getSHA1()"})
  void testGetSHA1() {
    // Arrange and Act
    MessageDigest actualSHA1 = MessageDigests.getSHA1();

    // Assert
    Provider provider = actualSHA1.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-1", actualSHA1.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(20, actualSHA1.getDigestLength());
  }

  /**
   * Test {@link MessageDigests#getSHA256()}.
   *
   * <p>Method under test: {@link MessageDigests#getSHA256()}
   */
  @Test
  @DisplayName("Test getSHA256()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageDigest MessageDigests.getSHA256()"})
  void testGetSHA256() {
    // Arrange and Act
    MessageDigest actualSHA256 = MessageDigests.getSHA256();

    // Assert
    Provider provider = actualSHA256.getProvider();
    assertEquals(194, provider.size());
    assertEquals("3072", provider.get("Signature.SHA3-384withDSA KeySize"));
    assertEquals("3072", provider.get("Signature.SHA384withDSA KeySize"));
    assertEquals("DSA", provider.get("Alg.Alias.KeyPairGenerator.1.2.840.10040.4.1"));
    assertEquals("SHA-256", actualSHA256.getAlgorithm());
    assertEquals("SHA-512/224", provider.get("Alg.Alias.MessageDigest.SHA512/224"));
    assertEquals("Software", provider.get("Signature.SHA3-384withDSA ImplementedIn"));
    assertEquals(
        "sun.security.provider.certpath.PKIXCertPathValidator",
        provider.get("CertPathValidator.PKIX"));
    assertEquals(Integer.SIZE, actualSHA256.getDigestLength());
  }
}
