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
}