/**
 * 
 */
package by.irun.viz.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import by.irun.controller.ControllerConstants;
import by.irun.domain.Gender;
import by.irun.domain.Runner;
import by.irun.domain.to.RunnerTO;
import by.irun.locale.AppLocales;
import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.viz.to.RunnerInfoTO;
import by.irun.viz.utils.VizUtils;

/**
 * test class for {@link by.irun.viz.utils.VizUtils}
 * @author A.Dubovik
 */
public class VizUtilsTest {

	@Test
	public void convertNumberOfSecondsToTimeRepresentationTest(){
		assertEquals("1:00:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3601));
		assertEquals("1:01:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3661));
		assertEquals("111:00:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(399601));
		assertEquals("59:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(3541));
		assertEquals("10:00",VizUtils.convertNumberOfSecondsToTimeRepresentation(600));
		assertEquals("5:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(301));
		assertEquals("0:30",VizUtils.convertNumberOfSecondsToTimeRepresentation(30));
		assertEquals("0:01",VizUtils.convertNumberOfSecondsToTimeRepresentation(1));
	}
	
	/**
	 * test for {@link by.irun.viz.utils.VizUtils#convertSqlDateToFrontEndRepresentation(java.sql.Date)}
	 */
	@Test
	public void convertSqlDateToFrontEndRepresentationTest(){
		assertEquals(VizUtils.UNKNOWN_DATE,VizUtils.convertSqlDateToFrontEndRepresentation(null));
		assertEquals("02.02.2000",VizUtils.convertSqlDateToFrontEndRepresentation(Date.valueOf("2000-02-02")));
	}
	
	/**
	 * test for {@link by.irun.viz.utils.VizUtils#resolveAvatarPathForRunner(RunnerInfoTO, Runner, java.util.Locale)}
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void resolveAvatarPathForRunnerTest() {
		RunnerTO runner = new RunnerTO();
		runner.setGender(Gender.FEMALE);
		RunnerInfoTO to = new RunnerInfoTO();
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.BY);
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_BY, to.getAvatar());
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.RU);
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_RU, to.getAvatar());
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.EN);
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_EN, to.getAvatar());
		runner.setGender(Gender.MALE);
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.BY);
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_BY, to.getAvatar());
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.RU);
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_RU, to.getAvatar());
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.EN);
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_EN, to.getAvatar());
		runner.setAvatar("path");
		to = new RunnerInfoTO();
		VizUtils.resolveAvatarPathForRunner(to, runner, AppLocales.DEFAULT);
		assertEquals("path", to.getAvatar());
	}
	
	/**
	 * test for {@link by.irun.viz.utils.VizUtils#getAvatarForAvatarPathAndGender(String, Gender, Locale)}
	 */
	@Test
	public void resolveAvatarPathForTest() {
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.FEMALE, AppLocales.BY));
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.FEMALE, AppLocales.EN));
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.FEMALE, AppLocales.RU));
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.MALE, AppLocales.BY));
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.MALE, AppLocales.EN));
		assertEquals("path",VizUtils.getAvatarForAvatarPathAndGender("path", Gender.MALE, AppLocales.RU));
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_BY,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.MALE, AppLocales.BY));
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_RU,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.MALE, AppLocales.RU));
		assertEquals(VizConstants.NO_FOTO_AVATAR_MAN_EN,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.MALE, AppLocales.EN));
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_BY,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.FEMALE, AppLocales.BY));
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_RU,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.FEMALE, AppLocales.RU));
		assertEquals(VizConstants.NO_FOTO_AVATAR_WOMAN_EN,VizUtils.getAvatarForAvatarPathAndGender(null, Gender.FEMALE, AppLocales.EN));
	}
	
	/**
	 * test for ({@link VizUtils#resolveClubLink(Long)}
	 */
	@Test
	public void resolveClubLinkTest(){
		assertEquals(VizUtils.EMPTY_LINK,VizUtils.resolveClubLink(null));
		assertEquals(ControllerConstants.CLUB_LINK+1,VizUtils.resolveClubLink(1L));
	}
	
	/**
	 * test for {@link VizUtils#resolveClubName(String, java.util.Locale)}
	 */
	@Test
	public void resolveClubNameTest(){
		assertEquals("Name",VizUtils.resolveClubName("Name", AppLocales.BY));
		assertEquals("Name",VizUtils.resolveClubName("Name", AppLocales.RU));
		assertEquals("Name",VizUtils.resolveClubName("Name", AppLocales.EN));
		assertEquals("без клубу",VizUtils.resolveClubName(null, AppLocales.BY));
		assertEquals("без клуба",VizUtils.resolveClubName(null, AppLocales.RU));
		assertEquals("no club",VizUtils.resolveClubName(null, AppLocales.EN));
	}
	
	/**
	 * test for {@link VizUtils#resolveClubLogo(String, java.util.Locale)}
	 */
	@Test
	public void resolveClubLogoTest() {
		assertEquals("logo", VizUtils.resolveClubLogo("logo", AppLocales.EN));
		assertEquals("logo", VizUtils.resolveClubLogo("logo", AppLocales.RU));
		assertEquals("logo", VizUtils.resolveClubLogo("logo", AppLocales.BY));
		assertEquals(VizConstants.CLUBLOGO_IS_NOT_UPLOADED_EN, VizUtils.resolveClubLogo(null, AppLocales.EN));
		assertEquals(VizConstants.CLUBLOGO_IS_NOT_UPLOADED_RU, VizUtils.resolveClubLogo(null, AppLocales.RU));
		assertEquals(VizConstants.CLUBLOGO_IS_NOT_UPLOADED_BY, VizUtils.resolveClubLogo(null, AppLocales.BY));
	}
	
	/**
	 * test for {@link VizUtils#concatName(String, String)}
	 */
	@Test
	public void concatNameTest(){
		assertEquals("First Last",VizUtils.concatName("First", "Last"));
	}
	/**
	 *  test for {@link VizUtils#buildRaceName(String, Date, java.util.Locale)}
	 */
	@Test
	public void buildRaceNameTest(){
		Date d = Date.valueOf("2000-01-01");
		String translationBY = Internationalizer.translate(d, AppLocales.BY);
		String translationRU = Internationalizer.translate(d, AppLocales.RU);
		String translationEN = Internationalizer.translate(d, AppLocales.EN);
		assertEquals("name "+translationBY,VizUtils.buildRaceName("name", d, AppLocales.BY));
		assertEquals("name "+translationRU,VizUtils.buildRaceName("name", d, AppLocales.RU));
		assertEquals("name "+translationEN,VizUtils.buildRaceName("name", d, AppLocales.EN));
	}
	
	/**
	 *  test for {@link VizUtils#isValidId(Long)}
	 */
	@Test
	public void isValidIdTest(){
		assertFalse(VizUtils.isValidId(null));
		assertFalse(VizUtils.isValidId(0L));
		assertFalse(VizUtils.isValidId(-1L));
		assertTrue(VizUtils.isValidId(1L));
	}
	
	@Test
	public void resolveClubNameTestForUnknown(){
		String nameBy = Internationalizer.translate(Translator.KEY_UNKNOWN, AppLocales.BY);
		String nameRu = Internationalizer.translate(Translator.KEY_UNKNOWN, AppLocales.RU);
		String nameEn = Internationalizer.translate(Translator.KEY_UNKNOWN, AppLocales.EN);
		assertEquals(nameBy,VizUtils.resolveClubName(null, null, AppLocales.BY));
		assertEquals(nameRu,VizUtils.resolveClubName(null, null, AppLocales.RU));
		assertEquals(nameEn,VizUtils.resolveClubName(null, null, AppLocales.EN));
	}
	
	@Test
	public void resolveClubNameTestForWithoutClub(){
		String nameBy = Internationalizer.translate(Translator.KEY_WITHOUTCLUB, AppLocales.BY);
		String nameRu = Internationalizer.translate(Translator.KEY_WITHOUTCLUB, AppLocales.RU);
		String nameEn = Internationalizer.translate(Translator.KEY_WITHOUTCLUB, AppLocales.EN);
		assertEquals(nameBy,VizUtils.resolveClubName(null, 1L, AppLocales.BY));
		assertEquals(nameRu,VizUtils.resolveClubName(null, 1L, AppLocales.RU));
		assertEquals(nameEn,VizUtils.resolveClubName(null, 1L, AppLocales.EN));
	}
	
	@Test
	public void resolveClubNameTestForDefinedNameb(){
		assertEquals("name",VizUtils.resolveClubName("name", 1L, AppLocales.BY));
		assertEquals("name",VizUtils.resolveClubName("name", 1L, AppLocales.RU));
		assertEquals("name",VizUtils.resolveClubName("name", 1L, AppLocales.EN));
	}
	
	@Test
	public void clubNameFirstLettersForClubClogoTest() {
		assertEquals("Mi", VizUtils.clubNameFirstLettersForClubClogo("Minskrun"));
		assertEquals("IB", VizUtils.clubNameFirstLettersForClubClogo("Irun Brest"));
		assertEquals("B2", VizUtils.clubNameFirstLettersForClubClogo("B2"));
		assertEquals("Б2", VizUtils.clubNameFirstLettersForClubClogo("Би-2"));
		assertEquals("Q", VizUtils.clubNameFirstLettersForClubClogo("Q"));
		assertEquals("B2", VizUtils.clubNameFirstLettersForClubClogo("B2"));
		assertEquals("B2", VizUtils.clubNameFirstLettersForClubClogo("B 22"));
		assertEquals("Bi", VizUtils.clubNameFirstLettersForClubClogo("Bit 22"));
		assertEquals("B2", VizUtils.clubNameFirstLettersForClubClogo("Bi 22"));
	}
}
