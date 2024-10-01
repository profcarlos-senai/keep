package com.keep.keep2.service;

import com.keep.keep2.model.M_Atividade;
import com.keep.keep2.repository.R_Atividade;
import org.hibernate.loader.ast.spi.Loadable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Atividade {
    private static R_Atividade r_atividade;

    public S_Atividade(R_Atividade r_atividade) {
        this.r_atividade = r_atividade;
    }

    public static M_Atividade cadastrarAtividade(String nome, String data){
        boolean podeSalvar = true;
        M_Atividade m_atividade = new M_Atividade();

        if(nome.trim().equalsIgnoreCase("")){
            podeSalvar = false;
        }
        m_atividade.setNome(nome);

        try{
            m_atividade.setData(LocalDate.parse(data));
        }catch (Exception e){
            podeSalvar = false;
        }

        if(podeSalvar){
            m_atividade.setConcluida(false);
            m_atividade = r_atividade.save(m_atividade);
            return m_atividade;
        }
        return null;
    }
}
