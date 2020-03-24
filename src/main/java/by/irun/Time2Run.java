package by.irun;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import by.irun.dao.CRUDHandler;
import by.irun.domain.Club;
import by.irun.domain.Gender;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;

@SpringBootApplication
public class Time2Run {

	private static CRUDHandler CRUD;

	public static void main(String[] args) {
		CRUD = SpringApplication.run(Time2Run.class).getBean(CRUDHandler.class);
		fillingTestData1();
		fillingTestData2();
		updateMinskRunAvatar();
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
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		Club club1 = new Club();
		Club club2 = new Club();
		club1.setAdmin(user1);
		club2.setAdmin(user2);
		club1.setBaseCity("Minsk");
		club2.setBaseCity("Brest");
		club1.setName("MINSKRUN CLUB");
		club2.setName("IRun Brest");

		try {
			CRUD.add(club1);
			CRUD.add(club2);
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
		r3.setCurrentClub(club1);
		r3.setDateOfBirth(Date.valueOf("1999-09-09"));
		r3.setCity("Minsk");
		r3.setGender(Gender.MALE);
		r3.setFirstName("Амвросий");
		r3.setLastName("Череззаборногузадерищенко");

		Runner r4 = new Runner();
		r4.setUser(user4);
		r4.setCurrentClub(club1);
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

		Runner r10 = new Runner();
		r10.setUser(user10);
		r10.setCurrentClub(club1);
		r10.setDateOfBirth(Date.valueOf("1955-01-01"));
		r10.setCity("Minsk");
		r10.setGender(Gender.MALE);
		r10.setFirstName("Александр");
		r10.setLastName("Отто");
		
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
		
		Runner r13 = new Runner();
		r13.setUser(user13);
		r13.setDateOfBirth(Date.valueOf("1990-11-11"));
		r13.setCity("Гродно");
		r13.setGender(Gender.FEMALE);
		r13.setFirstName("Александра");
		r13.setLastName("Павлова");
		
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
		r16.setDateOfBirth(Date.valueOf("1966-06-06"));
		r16.setCity("Minsk");
		r16.setGender(Gender.FEMALE);
		r16.setFirstName("Маша");
		r16.setLastName("Растеряша");
		
		Runner r17 = new Runner();
		r17.setUser(user17);
		r17.setDateOfBirth(Date.valueOf("1977-07-07"));
		r17.setCity("Minsk");
		r17.setGender(Gender.FEMALE);
		r17.setFirstName("Ольга");
		r17.setLastName("Гур");
		
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
		
		Runner r22 = new Runner();
		r22.setUser(user22);
		r22.setCurrentClub(club1);
		r22.setDateOfBirth(Date.valueOf("1988-09-09"));
		r22.setCity("Minsk");
		r22.setGender(Gender.MALE);
		r22.setFirstName("Лёва");
		r22.setLastName("Уг");
		
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
		
		Runner r25 = new Runner();
		r25.setUser(user25);
		r25.setDateOfBirth(Date.valueOf("1998-03-04"));
		r25.setCity("Toronto");
		r25.setGender(Gender.FEMALE);
		r25.setFirstName("Vasilisa");
		r25.setLastName("Thorn");

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
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		Park park1 = new Park();
		park1.setName("Парк Калиновского");
		Park park2 = new Park();
		park2.setName("Брестский парк");

		try {
			CRUD.add(park1);
			CRUD.add(park2);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		try {
			createRace(park1, Date.valueOf("2019-12-7"), r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25);
			createRace(park1, Date.valueOf("2019-12-14"),r8,r9,r4,r5,r6,r7,r13,r14,r15,r16,r17,r18,r19,r10,r11,r12, r1,r2,r21,r25);
			createRace(park1, Date.valueOf("2019-12-21"), r2,r3,r4,r5,r6,r7,r9,r16,r17,r19,r20,r22,r23,r24,r25,r10,r11,r12,r13,r15);
			createRace(park1, Date.valueOf("2019-12-28"), r1,null,r3,r12,r13,r10,r11,r15,r16,r17,r18,r19,r14,null,r5,r6,r7,r8,r9,r20,null,r22,null,r24,r25);
			createRace(park2, Date.valueOf("2020-01-4"), r11, r12, r13, r14, r15, r15, r17, r18, r19, r10);
			createRace(park1, Date.valueOf("2020-01-4"), r9, r8, r1, r2, r7, r22);
			createRace(park1, Date.valueOf("2020-01-11"), r6,r7,r8,r9,r10,r11,null,null,r14,r13,r2,r1,r3,r4,r5,null,r15,r16,r17,r20,null,r23,r24,r25,r18,r19);
			createRace(park1, Date.valueOf("2020-01-18"), r1,null,null,r14,r15,r16,r3,r4,r5,null,r11,r12,r13,null,r20,r21,r22,r23,r6,r7,r8,r9,r19,r24,r25,r10,r17,r18);
			createRace(park1, Date.valueOf("2020-01-25"), r1,r4,r5,null,r17,r18,r19,r8,r9,r10,r11,null,r13,null,r6,r2,r3,r7,r14,r16,null,r21,null,r23,r24,r25,r15,r12);
			createRace(park1, Date.valueOf("2020-02-1"), r4,r5,r1,r18,null,r8,r9,r10,r11,null,r13,null,null,r7,r14,r16,null,null,r6,r2,r3,r21,null,r23,r25,r12);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Data has been submitted successfully");
	}

	private static void createRace(Park park, Date date, Runner... runners) throws SQLException {
		createRace(null,park, date, runners);
	}
	
	private static void createRace(Long raceId, Park park, Date date, Runner... runners) throws SQLException {
		Race race = new Race();
		if (raceId != null)
			race.setId(raceId);
		race.setPark(park);
		race.setDate(date);
		CRUD.add(race);
		int pos = 1;
		long seconds = (int) (Math.random() * 300) + 1000;
		for (Runner r : runners) {
			Result res = new Result();
			res.setAbsolutePosition(pos++);
			res.setGender(r != null ? r.getGender() : Math.random() > 0.5 ? Gender.FEMALE : Gender.MALE);
			res.setRace(race);
			res.setTime(Duration.ofSeconds(seconds += (Math.random() * 60)));
			res.setClub(r != null ? r.getCurrentClub() : null);
			res.setRunner(r);
			CRUD.add(res);
		}
	}

	private static void fillingTestData2() {
		try {
			updateAvatars(32L, "../../images/test/test_woman_01.png", "../../images/test/test_woman_SMALL_01.png");
			updateAvatars(46L, "../../images/test/test_woman_04.png", "../../images/test/test_woman_SMALL_02.png");
			updateAvatars(50L, "../../images/test/test_woman_02.png", "../../images/test/test_woman_SMALL_03.png");
			updateAvatars(33L, "../../images/test/test_man_01.png", "../../images/test/test_man_SMALL_01.png");
			updateAvatars(37L, "../../images/test/test_man_02.png", "../../images/test/test_man_SMALL_02.png");
			System.out.println("PICTURES HAS BEEN ADDED");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateAvatars(Long runnerId, String bigPic, String smallPic) throws SQLException{
		Runner runner = (Runner) CRUD.getEntityById(Runner.class, runnerId);
		Picture picBig = new Picture();
		picBig.setLocation(bigPic);
		CRUD.add(picBig);;
		Picture picSmall = new Picture();
		picSmall.setLocation(smallPic);
		CRUD.add(picSmall);
		runner.setAvatar(picBig);
		runner.setLogo(picSmall);
		CRUD.update(runner);
	}
	
	private static void updateMinskRunAvatar(){
		try {
			Club club = (Club) CRUD.getEntityById(Club.class, 26L);
			if(club==null)return;
			Picture pic = new Picture();
			pic.setLocation("../../images/test/minskrun_logo.png");
			CRUD.add(pic);
			club.setSmallLogo(pic);
			CRUD.update(club);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}