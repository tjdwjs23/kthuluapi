package kr.co.abc.kthuluapi.token.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokenRepository extends JpaRepository<Token, Long>, JpaSpecificationExecutor<Token> {

}