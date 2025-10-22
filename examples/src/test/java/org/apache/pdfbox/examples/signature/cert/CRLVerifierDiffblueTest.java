package org.apache.pdfbox.examples.signature.cert;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.provider.X509CRLEntryObject;
import org.bouncycastle.jce.provider.X509CRLObject;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CRLVerifierDiffblueTest {
  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with 'A' and MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithAAndMin_value()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any()))
        .thenReturn(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithAAndMinusOne()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and minus one hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with 'A' and minus one hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithAAndMinusOneHundredTwelve()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', -112, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with 'A' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithAAndOne()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', 1, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>());

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with 'A' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithAAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>());

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code ,} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with ',' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithCommaAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{',', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@link Byte#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndMin_value()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any()))
        .thenReturn(new byte[]{-1, Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndMinusOne()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndX()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndX2()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, 'X', 'X', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndX3()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>());

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndX4()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any()))
        .thenReturn(new byte[]{-1, 'X', Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndX5()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, 'X', 'A', 'X', 0, 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with minus one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with minus one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithMinusOneAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{-1, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with one and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with one and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithOneAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{1, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with tab and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with tab and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithTabAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'\t', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with two and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with two and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithTwoAndZero()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{2, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenArrayOfByteWithZeroAndX()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertThrows(CertificateVerificationException.class,
        () -> CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>()));
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenEmptyArrayOfByte()
      throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{});
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>());

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
  }

  /**
   * Test {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#verifyCertificateCRLs(X509Certificate, Date, Set)}
   */
  @Test
  @DisplayName("Test verifyCertificateCRLs(X509Certificate, Date, Set); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.verifyCertificateCRLs(X509Certificate, Date, Set)"})
  void testVerifyCertificateCRLs_givenNull() throws CertificateVerificationException, RevokedCertificateException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(null);
    Date signDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    CRLVerifier.verifyCertificateCRLs(cert, signDate, new HashSet<>());

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
  }

  /**
   * Test {@link CRLVerifier#checkRevocation(X509CRL, X509Certificate, Date, String)}.
   * <p>
   * Method under test: {@link CRLVerifier#checkRevocation(X509CRL, X509Certificate, Date, String)}
   */
  @Test
  @DisplayName("Test checkRevocation(X509CRL, X509Certificate, Date, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.checkRevocation(X509CRL, X509Certificate, Date, String)"})
  void testCheckRevocation() throws RevokedCertificateException {
    // Arrange
    X509CRLEntryObject x509crlEntryObject = mock(X509CRLEntryObject.class);
    when(x509crlEntryObject.getRevocationDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    X509CRLObject crl = mock(X509CRLObject.class);
    when(crl.getRevokedCertificate(Mockito.<X509Certificate>any())).thenReturn(x509crlEntryObject);

    // Act and Assert
    assertThrows(RevokedCertificateException.class,
        () -> CRLVerifier.checkRevocation(crl, null,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "https://example.org/example"));
    verify(crl).getRevokedCertificate((X509Certificate) isNull());
    verify(x509crlEntryObject, atLeast(1)).getRevocationDate();
  }

  /**
   * Test {@link CRLVerifier#checkRevocation(X509CRL, X509Certificate, Date, String)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link X509CRLObject} {@link X509CRL#getRevokedCertificate(X509Certificate)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#checkRevocation(X509CRL, X509Certificate, Date, String)}
   */
  @Test
  @DisplayName("Test checkRevocation(X509CRL, X509Certificate, Date, String); given 'null'; when X509CRLObject getRevokedCertificate(X509Certificate) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CRLVerifier.checkRevocation(X509CRL, X509Certificate, Date, String)"})
  void testCheckRevocation_givenNull_whenX509CRLObjectGetRevokedCertificateReturnNull()
      throws RevokedCertificateException {
    // Arrange
    X509CRLObject crl = mock(X509CRLObject.class);
    when(crl.getRevokedCertificate(Mockito.<X509Certificate>any())).thenReturn(null);

    // Act
    CRLVerifier.checkRevocation(crl, null,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
        "https://example.org/example");

    // Assert
    verify(crl).getRevokedCertificate((X509Certificate) isNull());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given array of byte with 'A' and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenArrayOfByteWithAAndOne() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given array of byte with 'A' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenArrayOfByteWithAAndZero() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code byte} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given array of byte with one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenArrayOfByteWithOneAndOne() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{1, 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given array of {@code byte} with two and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given array of byte with two and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenArrayOfByteWithTwoAndOne() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{2, 1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenEmptyArrayOfByte() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getSubjectX500Principal()).thenReturn(new X500Principal(""));
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(new byte[]{});

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    verify(cert).getSubjectX500Principal();
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }

  /**
   * Test {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CRLVerifier#getCrlDistributionPoints(X509Certificate)}
   */
  @Test
  @DisplayName("Test getCrlDistributionPoints(X509Certificate); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CRLVerifier.getCrlDistributionPoints(X509Certificate)"})
  void testGetCrlDistributionPoints_givenNull() throws IOException {
    // Arrange
    X509CertificateObject cert = mock(X509CertificateObject.class);
    when(cert.getExtensionValue(Mockito.<String>any())).thenReturn(null);

    // Act
    List<String> actualCrlDistributionPoints = CRLVerifier.getCrlDistributionPoints(cert);

    // Assert
    verify(cert).getExtensionValue(eq("2.5.29.31"));
    assertTrue(actualCrlDistributionPoints.isEmpty());
  }
}
