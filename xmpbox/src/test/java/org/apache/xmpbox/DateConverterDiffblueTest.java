package org.apache.xmpbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

class DateConverterDiffblueTest {
  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]"));
    assertNull(DateConverter.toCalendar(null));
    assertNull(DateConverter.toCalendar(""));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-01yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/012020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020/03/01yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("20200301yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("--"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-Z"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("-yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*Z"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("^\\d{4}-\\d{2}-\\d{2}T.*yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("D:D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T][-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]Z"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("[-:T]yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("DateD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Date[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("DateGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Dateyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("422020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("42yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTDate"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMT42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTUnknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTZ"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTunknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("GMTyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("UnknownD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknown[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("UnknownGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Unknownyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("ZD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Z[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("ZGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("Zyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknown[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("unknownyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssDate"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssUnknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssZ"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssunknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'D:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'Z"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'unknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss'Z'yyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SDate"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.S42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SUnknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.SZ"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Sunknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ss.Syyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz2020-03-01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz2020/03/01"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz20200301"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz-"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszD:"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszDate"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:ssz42"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszGMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszUnknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszZ"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszunknown"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss'Z'"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ss.S"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("yyyy-MM-dd'T'HH:mm:sszyyyy-MM-dd'T'HH:mm:ssz"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01^\\d{4}-\\d{2}-\\d{2}T.*"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01[-:T]"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01Date"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01GMT"));
    assertThrows(IOException.class, () -> DateConverter.toCalendar("2020-03-012020-03-01Unknown"));
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar2() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar3() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-0120200301");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar4() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("202003012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar5() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-012020-03-01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar6() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-012020/03/01");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar7() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-0120200301");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:40", timeZone.getDisplayName());
    assertEquals("GMT-00:40", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583096403000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar8() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01-");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar9() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-01D:");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-02:59", timeZone.getDisplayName());
    assertEquals("GMT-02:59", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583104740000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link DateConverter#toCalendar(String)}
   */
  @Test
  void testToCalendar10() throws IOException {
    // Arrange and Act
    Calendar actualToCalendarResult = DateConverter.toCalendar("2020-03-012020-03-0142");

    // Assert
    assertTrue(actualToCalendarResult instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("2020-03-01", simpleDateFormat.format(actualToCalendarResult.getTime()));
    TimeZone timeZone = actualToCalendarResult.getTimeZone();
    assertEquals("GMT-00:18", timeZone.getDisplayName());
    assertEquals("GMT-00:18", timeZone.getID());
    assertEquals("gregory", actualToCalendarResult.getCalendarType());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, actualToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1583095083000L, actualToCalendarResult.getTimeInMillis());
    assertEquals(2020, actualToCalendarResult.getWeekYear());
    assertEquals(52, actualToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualToCalendarResult.isLenient());
    assertTrue(actualToCalendarResult.isWeekDateSupported());
  }
}
