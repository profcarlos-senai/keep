package com.keep.keep2.controller;

import com.keep.keep2.model.M_Atividade;
import com.keep.keep2.model.M_Resposta;
import com.keep.keep2.service.S_Atividade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Atividade {
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("atividades",S_Atividade.getAtividades());
        return "index";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam("atividade") String atividade,
                            @RequestParam("data") String data,
                            @RequestParam(name = "id",required = false) Long id,
                            @RequestParam("concluida") boolean concluida,
                            Model model){
        M_Atividade m_atividade = S_Atividade.cadastrarAtividade(atividade, data, id, concluida);
        model.addAttribute("atividade",m_atividade);
        if(m_atividade != null){
            return "pv/atividade";
        }
        return "pv/empty";
    }

    @PostMapping("/deletarAtividade")
    @ResponseBody
    public M_Resposta deletarAtividade(@RequestParam("id") int id){
        if(S_Atividade.deletarAtividade(id)){
            return new M_Resposta(true,"Atividade deletada com sucesso");
        }
        return new M_Resposta(false,"Erro ao deletar a atividade");
    }

    @PostMapping("/atualizarAtividade")
    @ResponseBody
    public M_Resposta atualizarAtividade(@RequestParam("id") Long id,
                                         @RequestParam("concluida") boolean concluida,
                                         @RequestParam("data") String data,
                                         @RequestParam("nome") String nome){
        return S_Atividade.atualizarAtividade(id,concluida,data,nome);
    }
}
