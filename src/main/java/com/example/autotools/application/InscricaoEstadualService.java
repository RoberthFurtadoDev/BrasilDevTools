package com.example.autotools.application;

import com.example.autotools.domain.Uf;
import com.example.autotools.web.dto.GeneratedIeDto;

public interface InscricaoEstadualService {
    GeneratedIeDto generateRandomIe(Uf uf);
}