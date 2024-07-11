import { useLoaderData } from 'react-router-dom';
import styled from 'styled-components';

const ItemDetails = styled.section`
    box-shadow: 0 1px 2px rgba(0,0,0,0.07), 
                0 2px 4px rgba(0,0,0,0.07), 
                0 4px 8px rgba(0,0,0,0.07), 
                0 8px 16px rgba(0,0,0,0.07),
                0 16px 32px rgba(0,0,0,0.07), 
                0 32px 64px rgba(0,0,0,0.07);
    
    float: left;
    flex: 1;
    margin: 10px;
    padding: 10px;

    h3 {
        text-align: center;
        margin-top: 2px;
    
    }
    div {
        display: grid;
    }
`
 
const Items = styled.div`
    display: flex;
`

const ItemDetail = styled.div`
    font-size: smaller;
    padding-bottom: 12px;
    display: grid;
`

const DetailSection = styled.section`
    
    h2 {
        font-size: 18px;
    }
    `


const Main = styled.main`
    padding: 10px;
    label {
        font-weight: bold;
    }
`


function PacoteDetails(props) {
  const pacote = useLoaderData();

  const itemDetails = pacote.items.map(x => <ItemPacoteDetails item={x}/>)

  return (
    <Main>
        <section>
            <h1>Pacote {pacote.id}</h1>
            <ItemDetail>
                <label>Descrição</label>
                <span>{pacote.descricao}</span>
            </ItemDetail>        
            <ItemDetail>
                <label>Localidade</label>
                <span>{pacote.localidade.descricao}</span>
            </ItemDetail>        
            <ItemDetail>
                <label>Valor Total</label>
                <span>R$ {pacote.valor}</span>
            </ItemDetail>
        </section>
        <DetailSection>
            <h2>Items inclusos</h2>
            <Items>
                {itemDetails}
            </Items>
        </DetailSection>
    </Main>
  )
}

function ItemPacoteDetails(props) {
    const { item } =  props;
    if (item.tipo === 'hotel') {
        return (
            <ItemDetails>
                <h3>Hotel</h3>
                    <ItemDetail>
                        <label>Nome do Hotel</label>
                        <span>{item.nomeHotel}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Endereço</label>
                        <span>{item.endereco}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Diária</label>
                        <span>R$ {item.preco}</span>
                    </ItemDetail>
            </ItemDetails>
        )
    } else if (item.tipo === 'voo') {
        return (
            <ItemDetails>
                <h3>Voo</h3>
                    <ItemDetail>
                        <label>Companhia Aerea</label>
                        <span>{item.companhiaAerea}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Voo</label>
                        <span>{item.numeroVoo}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Preço</label>
                        <span>R$ {item.preco}</span>
                    </ItemDetail>
            </ItemDetails>
        )
    } else if (item.tipo === 'veiculo') {
        return (
            <ItemDetails>
                <h3>Veiculo</h3>
                <ItemDetail>
                        <label>Marca</label>
                        <span>{item.marca}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Modelo</label>
                        <span>{item.modelo}</span>
                    </ItemDetail>
                    <ItemDetail>
                        <label>Diária</label>
                        <span>R$ {item.preco}</span>
                    </ItemDetail>
            </ItemDetails>

        )
    }
}

export default PacoteDetails;