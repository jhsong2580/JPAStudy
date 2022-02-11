package jpabasic.ex1hellojpa;

import jpabasic.ex1hellojpa.domain.Team;
import jpabasic.ex1hellojpa.domain4.Member4;
import jpabasic.ex1hellojpa.domain4.Order4;
import jpabasic.ex1hellojpa.domainForJqpl.JpqlMember;
import jpabasic.ex1hellojpa.domainForJqpl.JpqlMemberDTO;
import jpabasic.ex1hellojpa.domainForJqpl.JpqlOrder;
import jpabasic.ex1hellojpa.domainForJqpl.JpqlTeam;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootApplication
public class Ex1HelloJpaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Ex1HelloJpaApplication.class, args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try{
//			Member4 member = new Member4();
//
//			member.setName("hello");
//			em.persist(member);
//
//			em.flush();
//			em.clear();
//
//			Member4 findMember = em.getReference(Member4.class, member.getId());
//
//
////			System.out.println("=======================================================");
////			System.out.println("findMember.getId( = " + findMember.getId());
////			System.out.println("findMember.getName() = " + findMember.getName());
//			System.out.println("findMember = " + findMember.getClass());
//
//
//			System.out.println(emf.getPersistenceUnitUtil().isLoaded(findMember)); //영속성 container에 reference unit 이 참조할수있능가?
//
//			em.flush();
//			em.clear();
//
//			Order4 order4 = new Order4();
//
//			order4.setMember4(member);
//			em.persist(order4);
//
//			em.flush();
//			em.clear();
//
//			Order4 findOrder = em.find(Order4.class, order4.getId());
//			System.out.println("=====================================");
//			System.out.println(findOrder.getMember4().getName());
//			//member.setWorkPeriod(new Period(new LocalDateType()));
//
//			////////////////////////////////////정적쿼리
//			List<Member4> resultList = em.createQuery("select m From Member4 m where m.name like '%ll%'",
//					Member4.class).getResultList();
//
//			resultList.iterator().forEachRemaining(m->{
//				System.out.println("m.getName() = " + m.getName());
//
//			});
//			//////////////////////////////////////Criteria 거의안씀...
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<Member4> query = cb.createQuery(Member4.class);
//			Root<Member4> m = query.from(Member4.class);
//			CriteriaQuery<Member4> cq = query.select(m).where(cb.equal(m.get("name"), "hello"));
//
//			List<Member4> resultList1 = em.createQuery(cq).getResultList();
//			resultList1.iterator().forEachRemaining(mm->{
//				System.out.println("m.getName() = " + mm.getName());
//			});
//
//			///////////////////////////////////////JPQL~~~~
//			JpqlMember jpqlMember = new JpqlMember();
//			jpqlMember.setUsername("JPQLMember");
//			JpqlOrder jpqlOrder = new JpqlOrder();
//			jpqlOrder.setCount(3);
//			jpqlOrder.setMember(jpqlMember);
//			JpqlTeam jpqlTeam = new JpqlTeam();
//			jpqlTeam.setName("myteam");
//			jpqlMember.setTeam(jpqlTeam);
//			em.persist(jpqlTeam);
//			em.persist(jpqlOrder);
//			em.persist(jpqlMember);
//
//			TypedQuery<String> query1 = em.createQuery(
//					"select m.username from JpqlMember m",
//					String.class
//			); //반환타입이 명확
//
//			Query query2 = em.createQuery(
//					"select m.username from JpqlMember m",
//					String.class
//			);//반환타입이 불명확
//
//			TypedQuery<JpqlMemberDTO> query3 = em.createQuery(
//					"select new jpabasic.ex1hellojpa.domainForJqpl.JpqlMemberDTO(m.username,m.age) from JpqlMember m",
//					JpqlMemberDTO.class
//			);
//			query3.getResultList().iterator().forEachRemaining(mmm->{
//				System.out.println(mmm);
//			});  //일부 데이터들을 가져올때 쉽게가져오는방법! DTO
//
//			//////////////////////////////////////////JPQL Paging
//			List<JpqlMember> resultList2 = em.createQuery(
//							"select m from JpqlMember m order by m.id desc",
//							JpqlMember.class
//					).setFirstResult(0)
//					.setMaxResults(3)
//					.getResultList();
//			for (JpqlMember jpqlMember1 : resultList2) {
//				System.out.println("jpqlMember1.getId() = " + jpqlMember1.getId());
//
//			}
//
//			//////////////////////////////////////////JPQL Join
//			TypedQuery<JpqlMember> query4 = em.createQuery(
//					"select m,t from JpqlMember m left join m.team t on t.name='A'", // team 이름이 A인 애만 member와 left join
//					JpqlMember.class
//			);
//
//
//			//////////////////////////////////////////Sub query
//			List<JpqlMember> resultList3 = em.createQuery("select m from JpqlMember m where m.age > (select avg(m2.age) from JpqlMember m2)",
//					JpqlMember.class).getResultList();
//
//			//em.createQuery("select m from JpqlMember m where exist(select t from m.team t where t.name='팀A')",JpqlMember.class); //팀A 인 Member들
//			//em.createQuery("select o from JpqlOrder o where o.orderAmount > ALL(select p.stockAmount from Product p)"); //전체사품 각각의 재고보다 주문량이 만은 주문들
//			//em.createQuery("select m from JpqlMember m where m.team = ANY(select  t from Team t)"); //어느팀이든 팀에 속한 사람들
//
//			//////////////////////////////////////////값타입
//			em.createQuery("select m.username, " +
//					"'HELLO', " + //String 값 넣기
//					"TRUE" +      // Boolean값 넣기
//					" from JpqlMember m where m.type = jpabasic.ex1hellojpa.domainForJqpl.MemberType.ADMIN"); //Enum type 넣기
//
//
//			///////////////////////CASE 조건식
//			em.createQuery(
//					"select " +
//							"case when m.age <= 10 then '학생요금'" +
//							"     when m.age > 10 then '일반요금'" +
//							"     else '호엨요금'" +
//							"end" +
//							"from JpqlMember m"
//			);
//
//			//////////////////coalesce
//			em.createQuery(
//					"select coalesce(m.username,'이름없는회원') from JpqlMember m "
//			); //사용자 이름이 없으면 '이름없는회원'을 반환
//
//			////////////////// NULLIF
//			em.createQuery(
//					"select NULLIF(m.username,'관리자') from JpqlMember m"
//			); //사용자 이름이 관리자면 Null, 아니면 본인으 ㅣ이름
//
//
//			////////////////fetch join
//			em.createQuery(
//					"select m from Member m join fetch m.team"
//			); //select m.*,t.* from Member m join m.team t

//			///////////////////////////querh 바꿔치기
//			String changeQuery = "select m from JpqlMember m where m.id = :member";
//			JpqlMember member1 = em.createQuery(changeQuery, JpqlMember.class)
//					.setParameter("member", member) // query에 :member을  member.id로 바꾼다. (객체를 넣으면 기본키로 바로 매핑이되버림!)
//					.getSingleResult();
//
//			JpqlTeam team = em.find(JpqlTeam.class, 1L);
//			changeQuery = "select m From JpqlMember m where m.team = :team";
//			List<JpqlMember> members = em.createQuery(changeQuery, JpqlMember.class)
//					.setParameter("team", team)
//					.getResultList();
//
//			////////////////////////NAMED query
//			//APP 실행 시점에 쿼리 검증!!! 정적쿼리밖에안됨

			JpqlMember namedQueryMember = new JpqlMember();
			namedQueryMember.setUsername("name");
			em.persist(namedQueryMember);
			em.flush();
			em.clear();
			em.createNamedQuery("JpqlMember.findByUserName", JpqlMember.class)
					.setParameter("username", namedQueryMember.getUsername())
					.getResultList();

			///////////////////Bulk 연산
			JpqlTeam team1 = new JpqlTeam();
			JpqlTeam team2 = new JpqlTeam();
			team1.setName("teamA");
			team2.setName("teamB");

			em.persist(team1);
			em.persist(team2);

			JpqlMember jpqlMember = new JpqlMember();
			JpqlMember jpqlMember1 = new JpqlMember();
			jpqlMember.setUsername("memberA");
			jpqlMember1.setUsername("memberB");
			jpqlMember.setAge(20);
			jpqlMember1.setAge(10);
			jpqlMember.setTeam(team1);
			jpqlMember1.setTeam(team2);

			em.persist(jpqlMember);
			em.persist(jpqlMember1);

			
			//fulsh가됨. 
			int resultCount = em.createQuery( //db에 17로 셋팅
					"update JpqlMember m set m.age = 17"
			).executeUpdate();
			em.clear(); //영속성 데이터와 DB 데이터 정합을 위해 영속성 초기화
			
			System.out.println(jpqlMember.getAge());; //db엔 17살이지만 영속성에는 적용이 되어있찌 않다.(그대로 20)
			System.out.println(em.find(JpqlMember.class, jpqlMember.getId()).getAge()); //17로 셋팅
			System.out.println("resultCount = " + resultCount); //
			tx.commit();
		}catch(Exception e){
			tx.rollback();

		}finally {
			em.close();
		}

		emf.close();

	}


}
 