import { loadPacotes } from "./stub.js";

// Função para criar cards a partir dos dados
function criarCards(data) {
    const container = document.querySelector('#placeholder');

    // Limpa o container antes de adicionar novos cards
    container.innerHTML = '';

    let i = 1; // Inicializa i fora do loop

    data.forEach(pacote => {
        const card = document.createElement('div');
        card.classList.add('card');

        const conteudo = `
            <div class="card-content">
                <h3>Pacote ${i}:</h3>
                <p><strong>Descrição:</strong> ${pacote.descricao}</p>
                <p><strong>Cidade:</strong> ${pacote.localidade.descricao}</p>
                <p><strong>Preço:</strong> R$ ${pacote.valor.toFixed(2).replace('.', ',')}</p>
                <p><strong>Hotel:</strong> ${pacote.items[0].nomeHotel}</p>
            </div>
        `;
        card.innerHTML = conteudo;
        container.appendChild(card);
        i++; // Incrementa i após cada iteração
    });
}

// Função chamada ao clicar no botão
function onLoadPacotes() {
    const placeholder = document.getElementById("placeholder");
    placeholder.innerHTML = "<p>Loading</p>";

    loadPacotes((data) => {
        // Verifica se há pacotes disponíveis
        if (data && data.length > 0) {
            criarCards(data);
        } else {
            placeholder.innerHTML = "<p>Nenhum pacote disponível</p>";
        }
    });
}

export { onLoadPacotes };
