package com.keep.keep2.service;

import com.keep.keep2.model.M_Atividade;
import com.keep.keep2.repository.R_Atividade;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public static List<M_Atividade> getAtividades(){
        return r_atividade.findAll();
    }

    public static boolean deletarAtividade(int id){
        try{
            r_atividade.deleteById(Long.parseLong(String.valueOf(id)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
