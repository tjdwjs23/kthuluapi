package kr.co.abc.kthuluapi.token.entity;

import org.hibernate.annotations.BatchSize;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TokenSpecification {

    /**
     * @description equal 조건문 생성
     * @param token_type {String} 조건값
     * @return {Specification<ServiceHistory>} Specification 객체
     */
    public static Specification<Token> equalTokenType(String token_type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("token_type"),token_type);
    }

    /**
     * @description like 조건문 생성
     * @param token_name {String} 조건값
     * @return {Specification<ServiceHistory>} Specification 객체
     */
    @BatchSize(size = 10)
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    public static Specification<Token> likeTokenName(String token_name) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            predicates.add(criteriaBuilder.like(root.get("token_name"), '%' + token_name + '%')); //might need to change ther Person.class to whatever matches the job
            predicates.add(criteriaBuilder.like(root.get("token_symbol"), '%' + token_name + '%'));
            return criteriaBuilder.or(predicates.toArray(new Predicate[] {}));
        };
    }

    /**
     * @description equal 조건문 생성
     * @param token_name {String} 조건값
     * @return {Specification<ServiceHistory>} Specification 객체
     */
    @BatchSize(size = 10)
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    public static Specification<Token> equalTokenSymbol(String token_name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("token_symbol"), token_name);
    }

}
