package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDActionSoundDiffblueTest {
  /**
   * Test {@link PDActionSound#PDActionSound(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionSound#PDActionSound(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionSound(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.<init>(COSDictionary)"})
  void testNewPDActionSound() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionSound(a).getCOSObject());
  }

  /**
   * Test {@link PDActionSound#PDActionSound()}.
   *
   * <p>Method under test: {@link PDActionSound#PDActionSound()}
   */
  @Test
  @DisplayName("Test new PDActionSound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.<init>()"})
  void testNewPDActionSound2() {
    // Arrange and Act
    PDActionSound actualPdActionSound = new PDActionSound();

    // Assert
    assertNull(actualPdActionSound.getNext());
    COSDictionary cOSObject = actualPdActionSound.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionSound.getSound());
    assertEquals(1.0f, actualPdActionSound.getVolume());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(actualPdActionSound.getMix());
    assertFalse(actualPdActionSound.getRepeat());
    assertFalse(actualPdActionSound.getSynchronous());
    assertEquals(PDAction.TYPE, actualPdActionSound.getType());
    assertEquals(PDActionSound.SUB_TYPE, actualPdActionSound.getSubType());
  }

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   *
   * <p>Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSound(COSStream)"})
  void testSetSound() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    COSStream sound = new COSStream(new RandomAccessStreamCacheImpl());
    sound.setDirect(false);
    sound.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Type is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); given PDActionSound() Type is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSound(COSStream)"})
  void testSetSound_givenPDActionSoundTypeIsEmptyString() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setType("");
    COSStream sound = new COSStream();

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link PDActionSound#PDActionSound()} Sound is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName(
      "Test setSound(COSStream); given PDActionSound(); when COSStream(); then PDActionSound() Sound is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSound(COSStream)"})
  void testSetSound_givenPDActionSound_whenCOSStream_thenPDActionSoundSoundIsCOSStream() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    COSStream sound = new COSStream();

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName("Test setSound(COSStream); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSound(COSStream)"})
  void testSetSound_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    COSStream sound = new COSStream();
    sound.setDirect(true);

    // Act
    pdActionSound.setSound(sound);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#setSound(COSStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionSound#PDActionSound()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSound(COSStream)}
   */
  @Test
  @DisplayName(
      "Test setSound(COSStream); when 'null'; then PDActionSound() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSound(COSStream)"})
  void testSetSound_whenNull_thenPDActionSoundCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSound(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Sound is {@link COSStream#COSStream()}.
   *   <li>Then return {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName(
      "Test getSound(); given PDActionSound() Sound is COSStream(); then return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDActionSound.getSound()"})
  void testGetSound_givenPDActionSoundSoundIsCOSStream_thenReturnCOSStream() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    COSStream sound = new COSStream();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(sound, pdActionSound.getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName(
      "Test getSound(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDActionSound.getSound()"})
  void testGetSound_givenPDActionSoundWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionSound(new COSDictionary()).getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName("Test getSound(); given PDActionSound(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDActionSound.getSound()"})
  void testGetSound_givenPDActionSound_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionSound().getSound());
  }

  /**
   * Test {@link PDActionSound#getSound()}.
   *
   * <ul>
   *   <li>Then return Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSound()}
   */
  @Test
  @DisplayName(
      "Test getSound(); then return Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDActionSound.getSound()"})
  void testGetSound_thenReturnKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream sound = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);
    sound.setKey(key);

    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSound(sound);

    // Act and Assert
    assertSame(key, pdActionSound.getSound().getKey());
  }

  /**
   * Test {@link PDActionSound#setVolume(float)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code -1.0000001}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName(
      "Test setVolume(float); given PDActionSound(); when '-1.0000001'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setVolume(float)"})
  void testSetVolume_givenPDActionSound_when10000001_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDActionSound().setVolume(-1.0000001f));
  }

  /**
   * Test {@link PDActionSound#setVolume(float)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When minus one.
   *   <li>Then {@link PDActionSound#PDActionSound()} Volume is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName(
      "Test setVolume(float); given PDActionSound(); when minus one; then PDActionSound() Volume is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setVolume(float)"})
  void testSetVolume_givenPDActionSound_whenMinusOne_thenPDActionSoundVolumeIsMinusOne() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setVolume(-1.0f);

    // Assert
    assertEquals(-1.0f, pdActionSound.getVolume());
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionSound#setVolume(float)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setVolume(float)}
   */
  @Test
  @DisplayName(
      "Test setVolume(float); given PDActionSound(); when ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setVolume(float)"})
  void testSetVolume_givenPDActionSound_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDActionSound().setVolume(10.0f));
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Volume is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume(); given PDActionSound() Volume is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDActionSound.getVolume()"})
  void testGetVolume_givenPDActionSoundVolumeIsOne_thenReturnOne() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setVolume(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdActionSound.getVolume());
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName(
      "Test getVolume(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDActionSound.getVolume()"})
  void testGetVolume_givenPDActionSoundWithAIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDActionSound(new COSDictionary()).getVolume());
  }

  /**
   * Test {@link PDActionSound#getVolume()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getVolume()}
   */
  @Test
  @DisplayName("Test getVolume(); given PDActionSound(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDActionSound.getVolume()"})
  void testGetVolume_givenPDActionSound_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDActionSound().getVolume());
  }

  /**
   * Test {@link PDActionSound#setSynchronous(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link PDActionSound#PDActionSound()} Synchronous.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSynchronous(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Synchronous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSynchronous(boolean)"})
  void testSetSynchronous_givenPDActionSound_whenFalse_thenNotPDActionSoundSynchronous() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSynchronous(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#setSynchronous(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code true}.
   *   <li>Then {@link PDActionSound#PDActionSound()} Synchronous.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setSynchronous(boolean)}
   */
  @Test
  @DisplayName(
      "Test setSynchronous(boolean); given PDActionSound(); when 'true'; then PDActionSound() Synchronous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setSynchronous(boolean)"})
  void testSetSynchronous_givenPDActionSound_whenTrue_thenPDActionSoundSynchronous() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setSynchronous(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Synchronous is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName(
      "Test getSynchronous(); given PDActionSound() Synchronous is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getSynchronous()"})
  void testGetSynchronous_givenPDActionSoundSynchronousIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(false);

    // Act and Assert
    assertFalse(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Synchronous is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName(
      "Test getSynchronous(); given PDActionSound() Synchronous is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getSynchronous()"})
  void testGetSynchronous_givenPDActionSoundSynchronousIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setSynchronous(true);

    // Act and Assert
    assertTrue(pdActionSound.getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName(
      "Test getSynchronous(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getSynchronous()"})
  void testGetSynchronous_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound(new COSDictionary()).getSynchronous());
  }

  /**
   * Test {@link PDActionSound#getSynchronous()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getSynchronous()}
   */
  @Test
  @DisplayName("Test getSynchronous(); given PDActionSound(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getSynchronous()"})
  void testGetSynchronous_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound().getSynchronous());
  }

  /**
   * Test {@link PDActionSound#setRepeat(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link PDActionSound#PDActionSound()} Repeat.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  @DisplayName(
      "Test setRepeat(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Repeat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setRepeat(boolean)"})
  void testSetRepeat_givenPDActionSound_whenFalse_thenNotPDActionSoundRepeat() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setRepeat(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#setRepeat(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code true}.
   *   <li>Then {@link PDActionSound#PDActionSound()} Repeat.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setRepeat(boolean)}
   */
  @Test
  @DisplayName(
      "Test setRepeat(boolean); given PDActionSound(); when 'true'; then PDActionSound() Repeat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setRepeat(boolean)"})
  void testSetRepeat_givenPDActionSound_whenTrue_thenPDActionSoundRepeat() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setRepeat(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Repeat is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound() Repeat is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getRepeat()"})
  void testGetRepeat_givenPDActionSoundRepeatIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(false);

    // Act and Assert
    assertFalse(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Repeat is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound() Repeat is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getRepeat()"})
  void testGetRepeat_givenPDActionSoundRepeatIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setRepeat(true);

    // Act and Assert
    assertTrue(pdActionSound.getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName(
      "Test getRepeat(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getRepeat()"})
  void testGetRepeat_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound(new COSDictionary()).getRepeat());
  }

  /**
   * Test {@link PDActionSound#getRepeat()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getRepeat()}
   */
  @Test
  @DisplayName("Test getRepeat(); given PDActionSound(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getRepeat()"})
  void testGetRepeat_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound().getRepeat());
  }

  /**
   * Test {@link PDActionSound#setMix(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link PDActionSound#PDActionSound()} Mix.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  @DisplayName(
      "Test setMix(boolean); given PDActionSound(); when 'false'; then not PDActionSound() Mix")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setMix(boolean)"})
  void testSetMix_givenPDActionSound_whenFalse_thenNotPDActionSoundMix() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setMix(false);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#setMix(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>When {@code true}.
   *   <li>Then {@link PDActionSound#PDActionSound()} Mix.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#setMix(boolean)}
   */
  @Test
  @DisplayName("Test setMix(boolean); given PDActionSound(); when 'true'; then PDActionSound() Mix")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionSound.setMix(boolean)"})
  void testSetMix_givenPDActionSound_whenTrue_thenPDActionSoundMix() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();

    // Act
    pdActionSound.setMix(true);

    // Assert
    COSDictionary cOSObject = pdActionSound.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Mix is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound() Mix is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getMix()"})
  void testGetMix_givenPDActionSoundMixIsFalse_thenReturnFalse() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(false);

    // Act and Assert
    assertFalse(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()} Mix is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound() Mix is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getMix()"})
  void testGetMix_givenPDActionSoundMixIsTrue_thenReturnTrue() {
    // Arrange
    PDActionSound pdActionSound = new PDActionSound();
    pdActionSound.setMix(true);

    // Act and Assert
    assertTrue(pdActionSound.getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName(
      "Test getMix(); given PDActionSound(COSDictionary) with a is COSDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getMix()"})
  void testGetMix_givenPDActionSoundWithAIsCOSDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound(new COSDictionary()).getMix());
  }

  /**
   * Test {@link PDActionSound#getMix()}.
   *
   * <ul>
   *   <li>Given {@link PDActionSound#PDActionSound()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionSound#getMix()}
   */
  @Test
  @DisplayName("Test getMix(); given PDActionSound(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionSound.getMix()"})
  void testGetMix_givenPDActionSound_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionSound().getMix());
  }
}
