package by.irun;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import by.irun.domain.Club;
import by.irun.domain.Gender;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;
import by.irun.persistance.dao.common.CRUDHandler;

@SpringBootApplication
public class Time2Run {

	private static CRUDHandler CRUD;

	public static void main(String[] args) {
		CRUD = SpringApplication.run(Time2Run.class).getBean(CRUDHandler.class);
		fillingTestData1();
		System.exit(0);
	}

	private static void fillingTestData1() {

		User user1 = new User();
		user1.setEmail("email1");
		user1.setLogin("login1");
		user1.setPassword("password1");
		user1.setPhone("phone");

		User user2 = new User();
		user2.setEmail("email2");
		user2.setLogin("login2");
		user2.setPassword("password2");
		user2.setPhone("123456");

		User user3 = new User();
		user3.setEmail("email3");
		user3.setLogin("login3");
		user3.setPassword("password3");
		user3.setPhone("1234561");

		User user4 = new User();
		user4.setEmail("email4");
		user4.setLogin("login4");
		user4.setPassword("password4");
		user4.setPhone("123456");

		User user5 = new User();
		user5.setEmail("email5");
		user5.setLogin("login5");
		user5.setPassword("password5");
		user5.setPhone("1234565");

		User user6 = new User();
		user6.setEmail("email6");
		user6.setLogin("login6");
		user6.setPassword("password6");
		user6.setPhone("1234566");

		User user7 = new User();
		user7.setEmail("email7");
		user7.setLogin("login7");
		user7.setPassword("password7");
		user7.setPhone("1234567");

		User user8 = new User();
		user8.setEmail("email8");
		user8.setLogin("login8");
		user8.setPassword("password8");
		user8.setPhone("1234568");

		User user9 = new User();
		user9.setEmail("email9");
		user9.setLogin("login9");
		user9.setPassword("password9");
		user9.setPhone("1234569");

		User user10 = new User();
		user10.setEmail("email10");
		user10.setLogin("login10");
		user10.setPassword("password10");
		user10.setPhone("12345610");
		
		User user11 = new User();
		user11.setEmail("email11");
		user11.setLogin("login11");
		user11.setPassword("password11");
		user11.setPhone("123456101");
		
		User user12 = new User();
		user12.setEmail("email12");
		user12.setLogin("login12");
		user12.setPassword("password12");
		user12.setPhone("123456122");
		
		User user13 = new User();
		user13.setEmail("email13");
		user13.setLogin("login13");
		user13.setPassword("password13");
		user13.setPhone("1234561223");
		
		User user14 = new User();
		user14.setEmail("email14");
		user14.setLogin("login14");
		user14.setPassword("password14");
		user14.setPhone("123456124");
		
		User user15 = new User();
		user15.setEmail("email15");
		user15.setLogin("login15");
		user15.setPassword("password15");
		user15.setPhone("123456125");
		
		User user16 = new User();
		user16.setEmail("email16");
		user16.setLogin("login16");
		user16.setPassword("password16");
		user16.setPhone("123456126");
		
		User user17 = new User();
		user17.setEmail("email17");
		user17.setLogin("login17");
		user17.setPassword("password17");
		user17.setPhone("123456127");
		
		User user18 = new User();
		user18.setEmail("email18");
		user18.setLogin("login18");
		user18.setPassword("password18");
		user18.setPhone("123456128");
		
		User user19 = new User();
		user19.setEmail("email19");
		user19.setLogin("login19");
		user19.setPassword("password19");
		user19.setPhone("123456129");
		
		User user20 = new User();
		user20.setEmail("email20");
		user20.setLogin("login20");
		user20.setPassword("password20");
		user20.setPhone("1234561220");
		
		User user21 = new User();
		user21.setEmail("email21");
		user21.setLogin("login21");
		user21.setPassword("password21");
		user21.setPhone("1234561221");
		
		User user22 = new User();
		user22.setEmail("email22");
		user22.setLogin("login22");
		user22.setPassword("password22");
		user22.setPhone("1234561222");
		
		User user23 = new User();
		user23.setEmail("email23");
		user23.setLogin("login23");
		user23.setPassword("password23");
		user23.setPhone("1234561223");
		
		User user24 = new User();
		user24.setEmail("email24");
		user24.setLogin("login24");
		user24.setPassword("password24");
		user24.setPhone("1234561224");
		
		User user25 = new User();
		user25.setEmail("email25");
		user25.setLogin("login25");
		user25.setPassword("password25");
		user25.setPhone("1234561225");
		
		User user26 = new User();
		user26.setEmail("email216");
		user26.setLogin("login216");
		user26.setPassword("password216");
		user26.setPhone("12345612216");
		
		User user27 = new User();
		user27.setEmail("email227");
		user27.setLogin("login227");
		user27.setPassword("password227");
		user27.setPhone("12345612227");
		
		User user28 = new User();
		user28.setEmail("email238");
		user28.setLogin("login238");
		user28.setPassword("password238");
		user28.setPhone("812345612238");
		
		User user29 = new User();
		user29.setEmail("9email24");
		user29.setLogin("9login24");
		user29.setPassword("9password24");
		user29.setPhone("91234561224");
		
		User user30 = new User();
		user30.setEmail("email2530");
		user30.setLogin("login2530");
		user30.setPassword("password2530");
		user30.setPhone("123456122530");
		
		User user31 = new User();
		user31.setEmail("3email21");
		user31.setLogin("3login21");
		user31.setPassword("3password21");
		user31.setPhone("31234561221");
		
		User user32 = new User();
		user32.setEmail("email2225");
		user32.setLogin("login2225");
		user32.setPassword("password2225");
		user32.setPhone("123456122225");
		
		User user33 = new User();
		user33.setEmail("email2333");
		user33.setLogin("login2333");
		user33.setPassword("password2333");
		user33.setPhone("123456122333");
		
		User user34 = new User();
		user34.setEmail("email233334");
		user34.setLogin("login2333334");
		user34.setPassword("password2333334");
		user34.setPhone("123456122333334");
		
		User user35 = new User();
		user35.setEmail("email25555");
		user35.setLogin("login25555");
		user35.setPassword("password255555");
		user35.setPhone("12345612255555");

		try {
			CRUD.add(user1);
			CRUD.add(user2);
			CRUD.add(user3);
			CRUD.add(user4);
			CRUD.add(user5);
			CRUD.add(user6);
			CRUD.add(user7);
			CRUD.add(user8);
			CRUD.add(user9);
			CRUD.add(user10);
			CRUD.add(user11);
			CRUD.add(user12);
			CRUD.add(user13);
			CRUD.add(user14);
			CRUD.add(user15);
			CRUD.add(user16);
			CRUD.add(user17);
			CRUD.add(user18);
			CRUD.add(user19);
			CRUD.add(user20);
			CRUD.add(user21);
			CRUD.add(user22);
			CRUD.add(user23);
			CRUD.add(user24);
			CRUD.add(user25);
			CRUD.add(user26);
			CRUD.add(user27);
			CRUD.add(user28);
			CRUD.add(user29);
			CRUD.add(user30);
			CRUD.add(user31);
			CRUD.add(user32);
			CRUD.add(user33);
			CRUD.add(user34);
			CRUD.add(user35);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		Club club1 = new Club();
		Club club2 = new Club();
		Club club3 = new Club();
		Club club4 = new Club();
		
		club1.setAdmin(user1);
		club2.setAdmin(user2);
		club3.setAdmin(user3);
		club4.setAdmin(user4);

		club1.setBaseCity("Minsk");
		club2.setBaseCity("Brest");
		club3.setBaseCity("Minsk");
		club4.setBaseCity("Minsk");
		
		club1.setName("MINSKRUN CLUB");
		club2.setName("IRun Brest");
		club3.setName("Всем Бег");
		club4.setName("Funny Runners");
		
		Picture picc1 = new Picture();
		picc1.setLocation("../../images/test/minskrun_avatar.png");
		Picture picc1m = new Picture();
		picc1m.setLocation("../../images/test/minskrun_logo.png");
		try {
			CRUD.add(picc1);
			CRUD.add(picc1m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		club1.setSmallLogo(picc1m);
		club1.setBigLogo(picc1);
		
		Picture pic3 = new Picture();
		pic3.setLocation("../../images/clubs/logo50.png");
		try {
			CRUD.add(pic3);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		club3.setSmallLogo(pic3);

		try {
			CRUD.add(club1);
			CRUD.add(club2);
			CRUD.add(club3);
			CRUD.add(club4);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		Runner r1 = new Runner();
		r1.setUser(user1);
		r1.setCurrentClub(club1);
		r1.setDateOfBirth(Date.valueOf("1980-01-01"));
		r1.setCity("Minsk");
		r1.setGender(Gender.MALE);
		r1.setFirstName("Damon");
		r1.setLastName("Hill");

		Runner r2 = new Runner();
		r2.setUser(user2);
		r2.setCurrentClub(club2);
		r2.setDateOfBirth(Date.valueOf("1982-02-02"));
		r2.setCity("Brest");
		r2.setGender(Gender.FEMALE);
		r2.setFirstName("Василиса");
		r2.setLastName("Микулишна");

		Runner r3 = new Runner();
		r3.setUser(user3);
		r3.setCurrentClub(club3);
		r3.setDateOfBirth(Date.valueOf("1999-09-09"));
		r3.setCity("Minsk");
		r3.setGender(Gender.MALE);
		r3.setFirstName("Амвросий");
		r3.setLastName("Череззаборногузадерищенко");

		Runner r4 = new Runner();
		r4.setUser(user4);
		r4.setCurrentClub(club4);
		r4.setDateOfBirth(Date.valueOf("1960-01-21"));
		r4.setCity("Minsk");
		r4.setGender(Gender.MALE);
		r4.setFirstName("Ибрагим");
		r4.setLastName("Удмурт");

		Runner r5 = new Runner();
		r5.setUser(user5);
		r5.setCurrentClub(club1);
		r5.setDateOfBirth(Date.valueOf("1985-05-05"));
		r5.setCity("Minsk");
		r5.setGender(Gender.FEMALE);
		r5.setFirstName("Ангелина");
		r5.setLastName("Петрова");

		Runner r6 = new Runner();
		r6.setUser(user6);
		r6.setCurrentClub(club1);
		r6.setDateOfBirth(Date.valueOf("1990-09-09"));
		r5.setCity("Minsk");
		r6.setGender(Gender.MALE);
		r6.setFirstName("Константин");
		r6.setLastName("Константинов");

		Runner r7 = new Runner();
		r7.setUser(user7);
		r7.setDateOfBirth(Date.valueOf("1987-07-07"));
		r7.setCity("Minsk");
		r7.setGender(Gender.MALE);
		r7.setFirstName("Mika");
		r7.setLastName("Hakkinen");

		Runner r8 = new Runner();
		r8.setUser(user8);
		r8.setCurrentClub(club1);
		r8.setDateOfBirth(Date.valueOf("1998-09-08"));
		r8.setCity("Minsk");
		r8.setGender(Gender.FEMALE);
		r8.setFirstName("Мишель");
		r8.setLastName("Обама");

		Runner r9 = new Runner();
		r9.setUser(user9);
		r9.setCurrentClub(club1);
		r9.setDateOfBirth(Date.valueOf("1989-09-07"));
		r9.setCity("Minsk");
		r9.setGender(Gender.MALE);
		r9.setFirstName("Бонифаций");
		r9.setLastName("Торнсунен");
		Picture pic9 = new Picture();
		pic9.setLocation("../../images/test/test_man_01.png");
		Picture pic9m = new Picture();
		pic9m.setLocation("../../images/test/test_man_SMALL_01.png");
		try {
			CRUD.add(pic9);
			CRUD.add(pic9m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r9.setAvatar(pic9);
		r9.setLogo(pic9m);
		

		Runner r10 = new Runner();
		r10.setUser(user10);
		r10.setCurrentClub(club1);
		r10.setDateOfBirth(Date.valueOf("1955-01-01"));
		r10.setCity("Minsk");
		r10.setGender(Gender.MALE);
		r10.setFirstName("Александр");
		r10.setLastName("Отто");
		Picture pic10 = new Picture();
		pic10.setLocation("../../images/test/test_man_02.png");
		Picture pic10m = new Picture();
		pic10m.setLocation("../../images/test/test_man_SMALL_02.png");
		try {
			CRUD.add(pic10);
			CRUD.add(pic10m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r10.setAvatar(pic10);
		r10.setLogo(pic10m);
		
		Runner r11 = new Runner();
		r11.setUser(user11);
		r11.setCurrentClub(club1);
		r11.setDateOfBirth(Date.valueOf("1975-01-01"));
		r11.setCity("Minsk");
		r11.setGender(Gender.MALE);
		r11.setFirstName("Александр");
		r11.setLastName("Портников");
		
		Runner r12 = new Runner();
		r12.setUser(user12);
		r12.setCurrentClub(club2);
		r12.setDateOfBirth(Date.valueOf("1985-05-21"));
		r12.setCity("Minsk");
		r12.setGender(Gender.MALE);
		r12.setFirstName("Отто");
		r12.setLastName("Веллер");
		Picture pic12 = new Picture();
		pic12.setLocation("../../images/test/test001.png");
		Picture pic12m = new Picture();
		pic12m.setLocation("../../images/test/test001-1.png");
		try {
			CRUD.add(pic12);
			CRUD.add(pic12m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r12.setAvatar(pic12);
		r12.setLogo(pic12m);
		
		Runner r13 = new Runner();
		r13.setUser(user13);
		r13.setDateOfBirth(Date.valueOf("1990-11-11"));
		r13.setCity("Гродно");
		r13.setGender(Gender.FEMALE);
		r13.setFirstName("Александра");
		r13.setLastName("Павлова");
		Picture pic13 = new Picture();
		pic13.setLocation("../../images/test/test_woman_01.png");
		Picture pic13m = new Picture();
		pic13m.setLocation("../../images/test/test_woman_SMALL_01.png");
		try {
			CRUD.add(pic13);
			CRUD.add(pic13m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r13.setAvatar(pic13);
		r13.setLogo(pic13m);
		
		Runner r14 = new Runner();
		r14.setUser(user14);
		r14.setCurrentClub(club1);
		r14.setDateOfBirth(Date.valueOf("2000-08-09"));
		r14.setCity("Minsk");
		r14.setGender(Gender.MALE);
		r14.setFirstName("Павел");
		r14.setLastName("Нурс");
		
		Runner r15 = new Runner();
		r15.setUser(user15);
		r15.setDateOfBirth(Date.valueOf("1988-11-01"));
		r15.setCity("Minsk");
		r15.setGender(Gender.MALE);
		r15.setFirstName("Гриша");
		r15.setLastName("Нувориша");
		
		Runner r16 = new Runner();
		r16.setUser(user16);
		r16.setDateOfBirth(Date.valueOf("1986-06-06"));
		r16.setCity("Minsk");
		r16.setGender(Gender.FEMALE);
		r16.setFirstName("Маша");
		r16.setLastName("Растеряша");
		Picture pic16 = new Picture();
		pic16.setLocation("../../images/test/test_woman_04.png");
		Picture pic16m = new Picture();
		pic16m.setLocation("../../images/test/test_woman_SMALL_02.png");
		try {
			CRUD.add(pic16);
			CRUD.add(pic16m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r13.setAvatar(pic16);
		r13.setLogo(pic16m);
		
		Runner r17 = new Runner();
		r17.setUser(user17);
		r17.setDateOfBirth(Date.valueOf("1977-07-07"));
		r17.setCity("Minsk");
		r17.setGender(Gender.FEMALE);
		r17.setFirstName("Ольга");
		r17.setLastName("Гур");
		Picture pic17 = new Picture();
		pic17.setLocation("../../images/test/test_woman_02.png");
		Picture pic17m = new Picture();
		pic17m.setLocation("../../images/test/test_woman_SMALL_03.png");
		try {
			CRUD.add(pic17);
			CRUD.add(pic17m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r17.setAvatar(pic17);
		r17.setLogo(pic17m);
		
		Runner r18 = new Runner();
		r18.setUser(user18);
		r18.setCurrentClub(club1);
		r18.setDateOfBirth(Date.valueOf("1958-08-01"));
		r18.setCity("Minsk");
		r18.setGender(Gender.MALE);
		r18.setFirstName("Михаил");
		r18.setLastName("Марков");
		
		Runner r19 = new Runner();
		r19.setUser(user19);
		r19.setCurrentClub(club1);
		r19.setDateOfBirth(Date.valueOf("1995-01-01"));
		r19.setCity("Minsk");
		r19.setGender(Gender.FEMALE);
		r19.setFirstName("Ольга");
		r19.setLastName("Брутто");
		
		Runner r20 = new Runner();
		r20.setUser(user20);
		r20.setDateOfBirth(Date.valueOf("1965-06-11"));
		r20.setCity("Minsk");
		r20.setGender(Gender.MALE);
		r20.setFirstName("Роман");
		r20.setLastName("Роман");
		
		Runner r21 = new Runner();
		r21.setUser(user21);
		r21.setDateOfBirth(Date.valueOf("1995-09-21"));
		r21.setCity("Minsk");
		r21.setGender(Gender.MALE);
		r21.setFirstName("Вова");
		r21.setLastName("Корова");
		Picture pic21 = new Picture();
		pic21.setLocation("../../images/test/test002.png");
		Picture pic21m = new Picture();
		pic21m.setLocation("../../images/test/test002-1.png");
		try {
			CRUD.add(pic21);
			CRUD.add(pic21m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r21.setAvatar(pic21);
		r21.setLogo(pic21m);
		
		Runner r22 = new Runner();
		r22.setUser(user22);
		r22.setCurrentClub(club1);
		r22.setDateOfBirth(Date.valueOf("1988-09-09"));
		r22.setCity("Minsk");
		r22.setGender(Gender.MALE);
		r22.setFirstName("Лёва");
		r22.setLastName("Уг");
		Picture pic22 = new Picture();
		pic22.setLocation("../../images/test/test003.png");
		Picture pic22m = new Picture();
		pic22m.setLocation("../../images/test/test003-1.png");
		try {
			CRUD.add(pic22);
			CRUD.add(pic22m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r22.setAvatar(pic22);
		r22.setLogo(pic22m);
		
		Runner r23 = new Runner();
		r23.setUser(user23);
		r23.setCurrentClub(club1);
		r23.setDateOfBirth(Date.valueOf("1983-03-03"));
		r23.setCity("Minsk");
		r23.setGender(Gender.FEMALE);
		r23.setFirstName("Лёля");
		r23.setLastName("Просто Лёля");
		
		Runner r24 = new Runner();
		r24.setUser(user24);
		r24.setCurrentClub(club1);
		r24.setDateOfBirth(Date.valueOf("1985-11-22"));
		r24.setCity("Minsk");
		r24.setGender(Gender.FEMALE);
		r24.setFirstName("Нина");
		r24.setLastName("Нинина");
		Picture pic24 = new Picture();
		pic24.setLocation("../../images/test/test004.png");
		Picture pic24m = new Picture();
		pic24m.setLocation("../../images/test/test004-1.png");
		try {
			CRUD.add(pic24);
			CRUD.add(pic24m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r24.setAvatar(pic24);
		r24.setLogo(pic24m);
		
		Runner r25 = new Runner();
		r25.setUser(user25);
		r25.setDateOfBirth(Date.valueOf("1998-03-04"));
		r25.setCity("Toronto");
		r25.setGender(Gender.FEMALE);
		r25.setFirstName("Vasilisa");
		r25.setLastName("Thorn");
		Picture pic25 = new Picture();
		pic25.setLocation("../../images/test/test005.png");
		Picture pic25m = new Picture();
		pic25m.setLocation("../../images/test/test005-1.png");
		try {
			CRUD.add(pic25);
			CRUD.add(pic25m);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		r25.setAvatar(pic25);
		r25.setLogo(pic25m);
		
		Runner r26 = new Runner();
		r26.setUser(user26);
		r26.setDateOfBirth(Date.valueOf("1996-06-06"));
		r26.setCity("Minsk");
		r26.setGender(Gender.FEMALE);
		r26.setFirstName("Мария");
		r26.setLastName("Ингеборг");
		
		Runner r27 = new Runner();
		r27.setUser(user27);
		r27.setDateOfBirth(Date.valueOf("1987-08-27"));
		r27.setCity("Minsk");
		r27.setGender(Gender.FEMALE);
		r27.setFirstName("Ольга");
		r27.setLastName("Ольгина");
		
		Runner r28 = new Runner();
		r28.setUser(user28);
		r28.setCurrentClub(club3);
		r28.setDateOfBirth(Date.valueOf("1988-10-11"));
		r28.setCity("Minsk");
		r28.setGender(Gender.MALE);
		r28.setFirstName("Фома");
		r28.setLastName("Фомин");
		
		Runner r29 = new Runner();
		r29.setUser(user29);
		r29.setCurrentClub(club4);
		r29.setDateOfBirth(Date.valueOf("1997-07-07"));
		r29.setCity("Minsk");
		r29.setGender(Gender.FEMALE);
		r29.setFirstName("Тракторина");
		r29.setLastName("Белазова");
		
		Runner r30 = new Runner();
		r30.setUser(user30);
		r30.setDateOfBirth(Date.valueOf("1985-06-18"));
		r30.setCity("Minsk");
		r30.setCurrentClub(club3);
		r30.setGender(Gender.MALE);
		r30.setFirstName("Изя");
		r30.setLastName("Трактор");
		
		Runner r31 = new Runner();
		r31.setUser(user31);
		r31.setDateOfBirth(Date.valueOf("1993-03-23"));
		r31.setCity("Minsk");
		r30.setCurrentClub(club4);
		r31.setGender(Gender.MALE);
		r31.setFirstName("Аляксандр");
		r31.setLastName("Мазураў");
		
		Runner r32 = new Runner();
		r32.setUser(user32);
		r32.setCurrentClub(club3);
		r32.setDateOfBirth(Date.valueOf("1982-09-29"));
		r32.setCity("Minsk");
		r32.setGender(Gender.MALE);
		r32.setFirstName("Александр");
		r32.setLastName("Солодуха");
		
		Runner r33 = new Runner();
		r33.setUser(user33);
		r23.setCurrentClub(club3);
		r33.setDateOfBirth(Date.valueOf("1981-03-13"));
		r33.setCity("Minsk");
		r33.setGender(Gender.FEMALE);
		r33.setFirstName("Renata");
		r33.setLastName("Voland");
		
		Runner r34 = new Runner();
		r34.setUser(user34);
		r34.setCurrentClub(club3);
		r34.setDateOfBirth(Date.valueOf("1990-11-12"));
		r34.setCity("Minsk");
		r34.setGender(Gender.FEMALE);
		r34.setFirstName("Zinaida");
		r34.setLastName("Sola");
		
		Runner r35 = new Runner();
		r35.setUser(user35);
		r35.setDateOfBirth(Date.valueOf("1993-03-03"));
		r35.setCity("Warsaw");
		r35.setGender(Gender.FEMALE);
		r35.setFirstName("Angelina");
		r35.setLastName("Kowalska");


		try {
			CRUD.add(r1);
			CRUD.add(r2);
			CRUD.add(r3);
			CRUD.add(r4);
			CRUD.add(r5);
			CRUD.add(r6);
			CRUD.add(r7);
			CRUD.add(r8);
			CRUD.add(r9);
			CRUD.add(r10);
			CRUD.add(r11);
			CRUD.add(r12);
			CRUD.add(r13);
			CRUD.add(r14);
			CRUD.add(r15);
			CRUD.add(r16);
			CRUD.add(r17);
			CRUD.add(r18);
			CRUD.add(r19);
			CRUD.add(r20);
			CRUD.add(r21);
			CRUD.add(r22);
			CRUD.add(r23);
			CRUD.add(r24);
			CRUD.add(r25);
			CRUD.add(r26);
			CRUD.add(r27);
			CRUD.add(r28);
			CRUD.add(r29);
			CRUD.add(r30);
			CRUD.add(r31);
			CRUD.add(r32);
			CRUD.add(r33);
			CRUD.add(r34);
			CRUD.add(r35);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		Park park1 = new Park();
		park1.setName("Парк Калиновского");
		Park park2 = new Park();
		park2.setName("Брестский парк");
		Park park3 = new Park();
		park3.setName("Парк Победы");

		try {
			CRUD.add(park1);
			CRUD.add(park2);
			CRUD.add(park3);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		try {
			createRace(park1, Date.valueOf("2019-12-7"), r1,r2,r3,r4,r5,r6,r7,r8,r9,null,null,r10,r11,null,r12,r13,r14,null,r15,r16,null,r17,r18,r19,null,r20,r21,null,r22,null,r23,r24,r25,r26,null,r27,null,r28,r29,r30,r31,null,r32,r33,null,r34,r35);
			createRace(park1, Date.valueOf("2019-12-14"), r2,null,r35,r4,r5,r26,r30,null,r9,r10,null,r12,r13,r14,r27,r16,r28,null,r19,r20,r29,r31,r23,r24,r35);
			createRace(park1, Date.valueOf("2019-12-21"), r1,r32,r3,r4,r5,r6,r7,r8,r33,r16,r17,r18,null,r19,null,r20,r35,r22,r23,r34,r25,r9,null,r10,r11,null,r12,r13,null,r14);
			createRace(park1, Date.valueOf("2019-12-28"), r1,r2,r33,r34,r35,null,r7,null,r15,r16,r17,r8,null,r10,r11,r19,null,r18,r14,r12,r20,r21,null,r25,null,r23);
			createRace(park1, Date.valueOf("2020-01-3"), r6,r7,r26,r9,r10,r11,null,null,r14,r13,r2,r1,r3,r4,r5,null,r15,r16,r17,r20,null,r23,r24,r25,r18,r19, r27, r29, r35);
			createRace(park1, Date.valueOf("2020-01-10"), r1,null,r26,null,r14,r15,r27,r16,r3,r4,r5,null,r28,r11,r12,r13,null,r29,r20,r21,r22,r23,r30,r6,r31,r7,r32,r8,r33,r9,r34,r19,r35,r24,r25,r10,r17,r18);
			createRace(park1, Date.valueOf("2020-01-17"), r1,null,r30,r12,r33,r10,r31,r15,r16,null,r17,r26,r18,r27,r19,r29,null,r14,null,r5,r6,r7,r8,r9,r20,null,r22,null,r24,r25);
			createRace(park1, Date.valueOf("2020-01-25"), r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25);
			createRace(park1, Date.valueOf("2020-02-1"), r1,null,null,r14,r15,r16,r3,r4,r5,null,r11,r12,r26,r13,null,r27,r20,r21,r22,r28,r23,r6,r7,r29,r8,r9,r19,r30,r24,r25,r31,r10,r32,r17,r33,null,r18,r34,null,r35);		
			createRace(park1, Date.valueOf("2020-02-8"), r1,r2,r3,null,r4,r26,null,r10,r11,null,r12,r13,r5,r6,r7,null,r8,r32,r14,r27,r16,null,r17,r28,r19,r20,r29,r30,r23,null,r24,r25);
			createRace(park1, Date.valueOf("2020-02-15"), r1,r26,r3,r4,r5,null,r27,r33,r8,r9,r10,r28,r12,null,r32,r14,r34,r29,r17,null,r18,r35,r31,null,r21,r22,r30,null,r24,null,null,r25);
			createRace(park1, Date.valueOf("2020-02-22"), r2,r1,r4,r3,r26,r6,r7,r28,r9,r10,r27,null,r12,r13,null,r14,r15,r16,r17,r18,null,r29,r20,r21,null,r22,r30,r31,r35);
			createRace(park1, Date.valueOf("2020-02-29"), r4,r26,r1,r5,r6,r7,r8,r9,r10,r11,r12,r13,r3,r15,null,r19,r18,r20,r21,r32,r23,r24,null);
			createRace(park1, Date.valueOf("2020-03-07"), r5,r2,r3,r4,null,r6,r7,r8,r9,r10,r26,r27,null,r28,r11,r12,r13,r14,r15,null,r29,r16,r17,r18,r30,null,r19,null,r20,r31,r32,r21,r33,null,r22,r34,r24,r25);
			createRace("Winter Trail",park2, Date.valueOf("2019-12-15"), r10,r11,r12,null,r14,null,null,null,r15,r16,r17,r26,r18,r27,r19,r32,r28,r20,r21,null,r22,r23,r24,r25);
			createRace("Ice Run",park2, Date.valueOf("2020-02-9"), r5,r6,r7,null,r9,r10,r33,r32,null,r16,r15,r14,r17,r34,r19,r20,r35,null,r24,r23,null,r25);
			createRace("Hello 1/8 Marathon",park3, Date.valueOf("2020-03-15"), r1,r2,null,r4,r5,r6,r14,r8,r9,r12,null,r10,r29,null,r23,r7,r28,r15,r16,r20,r26,r19,r33,null,r27,r18,r34,null,r35,r17,null,r21,r22,null,r13,null,null,r24,null,null,r25);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Data has been submitted successfully");
	}

	private static void createRace(Park park, Date date, Runner... runners) throws SQLException {
		createRace(null, park, date, runners);
	}
	
	private static void createRace(String name, Park park, Date date, Runner... runners) throws SQLException {
		Race race = new Race();
		race.setName(name);
		race.setPark(park);
		race.setDate(date);
		CRUD.add(race);
		int pos = 1;
		int gap = (int)((((double)runners.length)/25)*60);
		long seconds = (int) (Math.random() * 300) + 1000;
		for (Runner r : runners) {
			Result res = new Result();
			res.setAbsolutePosition(pos++);
			res.setGender(r != null ? r.getGender() : Math.random() > 0.5 ? Gender.FEMALE : Gender.MALE);
			res.setRace(race);
			res.setTime(Duration.ofSeconds(seconds += (Math.random() * gap)));
			res.setClub(r != null ? r.getCurrentClub() : null);
			res.setRunner(r);
			CRUD.add(res);
		}
	}
	
}