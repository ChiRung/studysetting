package com.studysetting.domain.comment;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
  Optional<ArrayList<CommentEntity>> findAllByMemoId(Long memoId);
  // Usage: commentRepo.findAllByMemoId(memoId).get()
}
