package com.hanwha.solbangulrest.comment.dto;

import jakarta.validation.constraints.NotBlank;

import com.hanwha.solbangulrest.comment.domain.Comment;
import com.hanwha.solbangulrest.post.domain.Post;
import com.hanwha.solbangulrest.user.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentSaveDto {

	private Long postId;
	private String loginId;

	@NotBlank(message = "댓글을 입력해주세요")
	private String content;

	public Comment toEntity(Post post, User author) {
		return Comment.builder()
			.post(post)
			.author(author)
			.content(content)
			.build();
	}

	@Builder
	public CommentSaveDto(Long postId, String loginId, String content) {
		this.postId = postId;
		this.loginId = loginId;
		this.content = content;
	}
}
