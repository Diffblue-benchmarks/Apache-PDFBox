package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SecurityHandlerFactoryDiffblueTest {
  /**
   * Test {@link SecurityHandlerFactory#registerHandler(String, Class, Class)}.
   *
   * <ul>
   *   <li>When {@link PublicKeySecurityHandler#FILTER}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandlerFactory#registerHandler(String, Class, Class)}
   */
  @Test
  @DisplayName("Test registerHandler(String, Class, Class); when FILTER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SecurityHandlerFactory.registerHandler(String, Class, Class)"})
  void testRegisterHandler_whenFilter() {
    // Arrange
    Class<SecurityHandler> securityHandler = SecurityHandler.class;
    Class<ProtectionPolicy> protectionPolicy = ProtectionPolicy.class;

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            SecurityHandlerFactory.INSTANCE.registerHandler(
                PublicKeySecurityHandler.FILTER, securityHandler, protectionPolicy));
  }

  /**
   * Test {@link SecurityHandlerFactory#newSecurityHandlerForFilter(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityHandlerFactory#newSecurityHandlerForFilter(String)}
   */
  @Test
  @DisplayName("Test newSecurityHandlerForFilter(String); when 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityHandler SecurityHandlerFactory.newSecurityHandlerForFilter(String)"})
  void testNewSecurityHandlerForFilter_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SecurityHandlerFactory.INSTANCE.newSecurityHandlerForFilter("Name"));
  }
}
