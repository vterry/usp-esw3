import LocalidadeRow from './LocalidadeRow.js';

import styled from 'styled-components';

const LocalidadesTable = styled.table`
  border-collapse: collapse;
`;

const HeaderRow = styled.tr`
  height: 60px;
  border-bottom: 1px solid;
`;

const HeaderCell = styled.th`
`;


const DescricaoCell = styled(HeaderCell)`
`

const EstadoCell = styled(HeaderCell)`
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
    </HeaderRow>
  )
}

export default LocalidadesGrid;