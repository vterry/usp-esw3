import { loadPacotes } from "./stub.js";

function onLoadPacotes() {
    const placeholder = document.getElementById("placeholder");
    placeholder.innerHTML = "<p>Loading</p>"
    loadPacotes((data) => {
        placeholder.innerHTML=`<p>${data.length} pacotes carregados</p>`;

        for (let i = 0; i < data.length; i++) {
            // console.log(data[i])
            console.log("DESCRICAO: " + data[i]["descricao"])
            console.log("CIDADE: " + data[i]["localidade"]["descricao"])
            // placeholder.innerHTML=`<p>${data[i]} pacotes carregados</p>`;
            for (let j = 0; j < data[i]["items"].length; j++)
                console.log(data[i]["items"][j])
        }
    })
}

// Descrição
// Cidade
// Preço - Valor Total
// Hotel


export { onLoadPacotes };