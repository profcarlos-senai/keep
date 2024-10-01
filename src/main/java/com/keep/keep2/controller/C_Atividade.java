package com.keep.keep2.controller;

import com.keep.keep2.model.M_Atividade;
import com.keep.keep2.service.S_Atividade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Atividade {
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam("atividade") String atividade,
                            @RequestParam("data") String data,
                            Model model){
        M_Atividade m_atividade = S_Atividade.cadastrarAtividade(atividade, data);
        model.addAttribute("atividade",m_atividade);
        if(m_atividade != null){
            return "pv/atividade";
        }
        return "pv/empty";
    }
}
