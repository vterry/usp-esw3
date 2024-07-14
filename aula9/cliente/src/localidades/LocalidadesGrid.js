import LocalidadeRow from './LocalidadeRow.js';

import styled from 'styled-components';

const LocalidadesTable = styled.table`
  border-collapse: collapse;
`;

const HeaderRow = styled.tr`
  height: 46px;
  border-bottom: 1px solid;
`;

const HeaderCell = styled.th`
`;


const DescricaoCell = styled(HeaderCell)`
`

const EstadoCell = styled(HeaderCell)`
`

const ValorCell = styled(HeaderCell)`
  text-align: right;
  padding-right: 12px;
`


function LocalidadesGrid(props) {
  const { dados } = props;
  const rows = dados.map((x) => (<LocalidadeRow localidade={x}/>))

  return (
      <LocalidadesTable>
          <LocalidadesTableHeader/>
          {rows}
      </LocalidadesTable>
  );
}

function LocalidadesTableHeader() {
  return (
    <HeaderRow>
      <DescricaoCell>Descrição</DescricaoCell>
      <EstadoCell>Estado</EstadoCell>
      <ValorCell>Preço</ValorCell>
    </HeaderRow>
  )
}

export default LocalidadesGrid;