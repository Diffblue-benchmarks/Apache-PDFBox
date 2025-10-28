package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class SecurityHandlerFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link SecurityHandlerFactory#registerHandler(String, Class, Class)}
   */
  @Test
  void testRegisterHandler() {
    // Arrange
    Class<SecurityHandler> securityHandler = SecurityHandler.class;
    Class<ProtectionPolicy> protectionPolicy = ProtectionPolicy.class;

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> SecurityHandlerFactory.INSTANCE
        .registerHandler(PublicKeySecurityHandler.FILTER, securityHandler, protectionPolicy));
  }

  /**
   * Method under test:
   * {@link SecurityHandlerFactory#newSecurityHandlerForFilter(String)}
   */
  @Test
  void testNewSecurityHandlerForFilter() {
    // Arrange, Act and Assert
    assertNull(SecurityHandlerFactory.INSTANCE.newSecurityHandlerForFilter("Name"));
  }
}
