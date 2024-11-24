package com.cia103g5.hibenateCompositeQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cia103g5.memberviolation.model.MemberViolationRecord;

public class ComppsiteQuery {
	
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<MemberViolationRecord> root, String columnName, String value) {
		
		Predicate predicate = null;
		
		return predicate;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MemberViolationRecord> getAll(Map<String, String[]> map, Session session){
		
		Transaction tx = session.beginTransaction();
		List<MemberViolationRecord> list = null;
		
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<MemberViolationRecord> criteriaQuery = builder.createQuery(MemberViolationRecord.class);
			Root<MemberViolationRecord> root = criteriaQuery.from(MemberViolationRecord.class);
			
			List<Predicate> predicateList = new ArrayList<Predicate>();
			
			Set<String> keys = map.keySet();
			int count = 0;
			for (String key : keys) {
				String value = map.get(key)[0];
				if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value.trim()));
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}
			System.out.println("predicateList.size()="+predicateList.size());
			criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
			criteriaQuery.orderBy(builder.asc(root.get("empno")));
			// 【●最後完成創建 javax.persistence.Query●】
			Query query = session.createQuery(criteriaQuery); //javax.persistence.Query; //Hibernate 5 開始 取代原 org.hibernate.Query 介面
			list = query.getResultList();

			tx.commit();
			
			
		}catch (RuntimeException re) {
			if (tx != null) {
				tx.rollback();
				System.out.println(re.getMessage());
			}
		}finally {
			session.close();
		}
		return list;
	}
}
