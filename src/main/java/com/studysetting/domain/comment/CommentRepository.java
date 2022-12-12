package com.studysetting.domain.comment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
  Optional<CommentEntity> findAllByMemoId(Long memoId);
}
