package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.security.Provider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SecurityProviderDiffblueTest {
  /**
   * Test {@link SecurityProvider#getProvider()}.
   * <p>
   * Method under test: {@link SecurityProvider#getProvider()}
   */
  @Test
  @DisplayName("Test getProvider()")
  void testGetProvider() {
    // Arrange and Act
    Provider actualProvider = SecurityProvider.getProvider();

    // Assert
    assertEquals(4544, actualProvider.size());
    assertEquals("PBKDF1", actualProvider.get("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.5.10"));
    assertEquals("PBKDF1", actualProvider.get("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.5.11"));
    assertEquals("PBKDF2", actualProvider.get("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.5.12"));
    assertEquals("POLY1305-RC6", actualProvider.get("Alg.Alias.Mac.POLY1305RC6"));
    assertEquals("SHA3-512WITHECDSA", actualProvider.get("Alg.Alias.Signature.SHA3-512/ECDSA"));
    assertEquals("org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512",
        actualProvider.get("Signature.SHA3-512WITHDSA"));
    assertEquals("org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi$MQVwithSHA384CKDF",
        actualProvider.get("KeyAgreement.ECMQVWITHSHA384CKDF"));
    assertEquals("org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384",
        actualProvider.get("Signature.SHA3-384WITHRSA"));
    assertEquals("org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSAandSHAKE256",
        actualProvider.get("Signature.SHA3-384WITHRSAANDSHAKE256"));
    assertEquals("org.bouncycastle.jcajce.provider.digest.SHA224$KeyGenerator",
        actualProvider.get("KeyGenerator.HMACSHA224"));
    assertEquals("org.bouncycastle.jcajce.provider.symmetric.RC2$PBEWithSHAAnd128BitKeyFactory",
        actualProvider.get("SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC"));
  }
}
