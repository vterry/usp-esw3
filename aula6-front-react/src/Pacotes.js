
import styled from 'styled-components';

const Message = styled.p`
`;

function Pacotes(props) {
  const { dados } = props;

  if (dados.length === 0) {
    return (
      <></>
  );
  } else {
    return (
      <div id="placeholder" className='container'>
          {dados.map((pacote, index) => (
            <div class="card">
              <div class="card-content">
                  <h3>Pacote {index}</h3>
                  <p><strong>Descrição:</strong> {pacote.descricao}</p>
                  <p><strong>Cidade:</strong> {pacote.localidade.descricao}</p>
                  <p><strong>Preço:</strong> R$ {pacote.valor.toFixed(2).replace('.', ',')}</p>
                  <p><strong>Hotel:</strong> {pacote.items[0].nomeHotel}</p>
              </div>
              </div>
          ))}
      </div>
  );
  }
}

export default Pacotes;