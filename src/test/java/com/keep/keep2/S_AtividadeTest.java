package com.keep.keep2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.keep.keep2.model.M_Atividade;
import com.keep.keep2.service.S_Atividade;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class S_AtividadeTest {
    @Autowired
    S_Atividade servico;

    M_Atividade atividade;

    @Test
    void CadastraAtividade(){
        LocalDate hoje = LocalDate.now();
        String strHoje = hoje.toString();

        atividade = S_Atividade.cadastrarAtividade("Tomar banho", strHoje, null, false);
        assertNotNull(atividade, "Atividade não pode ser nulo");
        assertEquals("Tomar banho", atividade.getNome(), "Cadastrou nome");
        assertEquals(hoje, atividade.getData());
        assertNotNull(atividade.getId());
        assertEquals(false, atividade.getConcluida());
    }
}
