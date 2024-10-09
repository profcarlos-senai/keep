function cadastrarAtividade(){
    let atividade = $("#atividade").val();
    let data = $("#data").val();
    $.ajax({
        url: "/cadastrar",
        method: "post",
        data: {
            atividade: atividade,
            data: data
        },
        success: function(data){
            $("#activity-container").append(data);
        },
        error: function(){
            alert("deu ruim");
        }
    });
}
$("#btSalvar").click(cadastrarAtividade);

function removerAtividade(element){
    let id = element.dataset.codigo;

    $.ajax({
        url: "/deletarAtividade",
        method: "POST",
        data:{
            id: id
        },
        success: function(data){
            alert(data.mensagem);
            if(data.sucesso){
                $("#a"+id).remove();
            }
        },
        error: function(){
            alert("Erro ao excluir a atividade");
        }
    })
}

function duvidoSairAlgumTCC(element){
    let id = element.dataset.codigo;
    let concluida = $(element).is(":checked");

    $.ajax({
        url: "/atualizarAtividade",
        method: "post",
        data:{
            id: id,
            concluida: concluida
        },
        success: function(data){
            alert(data.mensagem);
            if(data.sucesso){
                let atividade = $("#a"+id);
                if(concluida){
                    atividade.addClass("tachado");
                }else{
                    atividade.removeClass("tachado");
                }
            }
        },
        error: function(){
            alert('falha ao registrar a conclusão da atividade');
        }
    })
}