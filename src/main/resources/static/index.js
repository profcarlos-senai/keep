function cadastrarAtividade(){
    let atividade = $("#atividade").val();
    let data = $("#data").val();
    let id = $("#id").val();
    $.ajax({
        url: "/cadastrar",
        method: "post",
        data: {
            id: id,
            atividade: atividade,
            data: data
        },
        success: function(data){
            if(id==""){
                $("#activity-container").append(data);
            }
            $("#exampleModal").modal('hide');
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
            if(data.sucesso){
                $("#a"+id).remove();
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert("Erro ao excluir a atividade");
        }
    });
}

function atualizarAtividade(element){
    let id = element.dataset.codigo;
    let data = element.dataset.data;
    let nome = element.dataset.nome;
    let concluida = $(element).is(":checked");

    $.ajax({
        url: "/atualizarAtividade",
        method: "post",
        data:{
            id: id,
            data:data,
            nome:nome,
            concluida: concluida
        },
        success: function(data){
            if(data.sucesso){
                let atividade = $(".a"+id);
                if(concluida){
                    $("#a"+id).addClass("done");
                }else{
                    $("#a"+id).removeClass("done");
                }
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert('falha ao registrar a conclusão da atividade');
        }
    });
}

function loadModal(element){
    let id = element.dataset.codigo;
    let data = element.dataset.data;
    let nome = element.dataset.nome;

    $("#exampleModalLabel").text("Atualizar Atividade");
    $("#divId").removeClass("d-none");
    $("#id").val(id);
    $("#atividade").val(nome);
    $("#data").val(data);
}

$("#exampleModal").on('hidden.bs.modal', function(){
    $("#exampleModalLabel").text("Cadastrar Atividade");
    $("#divId").addClass("d-none");
    $("#atividade").val('');
    $("#data").val('');
});