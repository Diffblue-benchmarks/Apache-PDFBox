package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.GregorianCalendar;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class DateTypeDiffblueTest {
  /**
   * Method under test: {@link DateType#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertNull(
        (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "")).getValue());
  }

  /**
   * Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  void testSetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("Value"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("42"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("-"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue(42));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("D:"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue("[-:T]"));
    assertThrows(IllegalArgumentException.class,
        () -> (new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", ""))
            .setValue(null));
  }

  /**
   * Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  void testSetValue2() {
    // Arrange
    DateType dateType = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");
    GregorianCalendar gregorianCalendar = new GregorianCalendar(1, 1, 1, 1, 1);

    // Act
    dateType.setValue(gregorianCalendar);

    // Assert
    assertSame(gregorianCalendar, dateType.getValue());
  }

  /**
   * Method under test: {@link DateType#setValue(Object)}
   */
  @Test
  void testSetValue3() {
    // Arrange
    DateType dateType = new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    dateType.setValue("");

    // Assert
    assertNull(dateType.getValue());
  }

  /**
   * Method under test:
   * {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewDateType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"));
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "-"));
    assertThrows(IllegalArgumentException.class, () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI",
        "Prefix", "Property Name", "^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "D:"));
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "[-:T]"));
    assertThrows(IllegalArgumentException.class,
        () -> new DateType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", null));
  }

  /**
   * Method under test:
   * {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewDateType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    GregorianCalendar gregorianCalendar = new GregorianCalendar(1, 1, 1, 1, 1);

    // Act
    DateType actualDateType = new DateType(metadata, "Namespace URI", "Prefix", "Property Name", gregorianCalendar);

    // Assert
    assertEquals("Namespace URI", actualDateType.getNamespace());
    assertEquals("Prefix", actualDateType.getPrefix());
    assertEquals("Property Name", actualDateType.getPropertyName());
    assertTrue(actualDateType.getAllAttributes().isEmpty());
    assertSame(gregorianCalendar, actualDateType.getRawValue());
    assertSame(gregorianCalendar, actualDateType.getValue());
    assertSame(metadata, actualDateType.getMetadata());
  }

  /**
   * Method under test:
   * {@link DateType#DateType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewDateType3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DateType actualDateType = new DateType(metadata, "Namespace URI", "Prefix", "Property Name", "");

    // Assert
    assertEquals("", actualDateType.getRawValue());
    assertEquals("Namespace URI", actualDateType.getNamespace());
    assertEquals("Prefix", actualDateType.getPrefix());
    assertEquals("Property Name", actualDateType.getPropertyName());
    assertNull(actualDateType.getValue());
    assertTrue(actualDateType.getAllAttributes().isEmpty());
    assertSame(metadata, actualDateType.getMetadata());
  }
}
