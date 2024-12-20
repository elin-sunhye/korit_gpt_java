package com.korit.basic.practice.table.service;

import com.korit.basic.practice.table.dto.request.QnaRequestDto;
import com.korit.basic.practice.table.dto.response.QnaResponseDto;
import com.korit.basic.practice.table.entity.Qna;
import com.korit.basic.practice.table.repository.QnaRepository;

import java.util.List;

// repository에서 데이터를 가져와 실행

public class QnaServiceImpl implements QnaService{

    private final QnaRepository repository;

    public QnaServiceImpl() {
        this.repository = new QnaRepository();
    }


    @Override
    public void createQna(QnaRequestDto requestDto) {

    }

    @Override
    public List<QnaResponseDto> allQnas() {

        return List.of();
    }

    @Override
    public void updateQna(Long id, QnaRequestDto requestDto) {

    }

    @Override
    public void deleteQna(Long id) {

    }
}
