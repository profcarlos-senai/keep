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
    $("#a"+id).remove();
}