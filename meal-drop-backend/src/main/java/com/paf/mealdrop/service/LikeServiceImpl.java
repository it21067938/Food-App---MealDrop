package com.paf.mealdrop.service;

import com.paf.mealdrop.model.Like;
import com.paf.mealdrop.repository.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    @Override
    public void addLike(Like like) {
        like.setLikedTime(LocalDateTime.now());
        likeRepository.save(like);
    }

    @Override
    public void removeLikeById(String likeId) {
        likeRepository.deleteById(likeId);
    }
}
