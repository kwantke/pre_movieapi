package kr.or.zeropay2.repository;

import kr.or.zeropay2.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;




public interface MemberRepository extends JpaRepository<MemberEntity, String> {

  Optional<MemberEntity> findById(@Param("id")String id);

  Optional<MemberEntity> findByIdAndPassword(String id, String password);
}
